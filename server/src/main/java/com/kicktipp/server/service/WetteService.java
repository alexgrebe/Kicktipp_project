package com.kicktipp.server.service;

import com.kicktipp.server.model.*;
import com.kicktipp.server.repository.SpielRepository;
import com.kicktipp.server.repository.UserRepository;
import com.kicktipp.server.repository.WettErlaubnisRepository;
import com.kicktipp.server.repository.WetteRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class WetteService {

    @Autowired
    private WetteRepository wetteRepository;

    @Autowired
    private SpielRepository spielRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WettErlaubnisRepository wettErlaubnisRepository;

    @Autowired
    private ConfigService configService;

    @Autowired
    JavaMailSender mailSender;

    public void createWette(Wette wette, Benutzer b) throws Exception {
        if(b.getGeld()<wette.getEinsatz() || !b.isWetterlaubnis() ) throw new Exception("");
        wette.setBenutzerID(b.getId());
        Optional<Spiel> wettSpiel = spielRepository.findById(wette.getSpielID());
        LocalDate date = configService.getSysTime();
        if(wettSpiel.isEmpty() || wettSpiel.get().getDatum().isBefore(date)) throw new Exception("");
        Quoten quote = quoteBerechnen(wettSpiel.get());
        if(Wette.Auswahl.HEIM==wette.getAuswahl()) wette.setQuote(quote.getHeim());
        if(Wette.Auswahl.AUSWAERTS==wette.getAuswahl()) wette.setQuote(quote.getAuswaerts());
        if(Wette.Auswahl.UNENTSCHIEDEN==wette.getAuswahl()) wette.setQuote(quote.getUnentschieden());
        b.setGeld(b.getGeld()-wette.getEinsatz());
        userRepository.save(b);
        System.out.println(wette.getQuote());
        wetteRepository.save(wette);
    }

    public Quoten quoteBerechnen(Spiel spielQuote) {
        Quoten quoten = new Quoten();
        double team1 = 1;
        double team2 = 1;
        List<Spiel> spiele = spielRepository.findGamesInLeagueBySpielIDBeforeSysTime(spielQuote.getId());
        List<Spiel> last5GamesHeim = spielRepository.findLast5GamesHome(spielQuote.getId());
        List<Spiel> last5GamesAus = spielRepository.findLast5GamesAus(spielQuote.getId());
        HashMap<String, Integer> tabelle = new HashMap<>();
        for(Spiel spiel : spiele) {
            if(!tabelle.containsKey(spiel.getHeimteam())) tabelle.put(spiel.getHeimteam(), 0);
            if(!tabelle.containsKey(spiel.getAuswaertsteam())) tabelle.put(spiel.getAuswaertsteam(), 0);
            if(spiel.getHeimtore()>spiel.getAuswaertstore())
                tabelle.put(spiel.getHeimteam(), tabelle.get(spiel.getHeimteam())+3);
            if(spiel.getHeimtore()<spiel.getAuswaertstore())
                tabelle.put(spiel.getAuswaertsteam(), tabelle.get(spiel.getAuswaertsteam())+3);
            if(spiel.getHeimtore()==spiel.getAuswaertstore()) {
                tabelle.put(spiel.getHeimteam(), tabelle.get(spiel.getHeimteam())+1);
                tabelle.put(spiel.getAuswaertsteam(), tabelle.get(spiel.getAuswaertsteam())+1);
            }
        }
        List<String> sortierteListe = tabelle.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder())).map(Map.Entry::getKey).toList();
        for(String out : sortierteListe) {
            System.out.println(out);
        }
        for(Map.Entry<String, Integer> entry : tabelle.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        for(int i=0; i<sortierteListe.size(); i++) {
            if(spielQuote.getHeimteam().equals(sortierteListe.get(i))) team1 += sortierteListe.size()-i;
            if(spielQuote.getAuswaertsteam().equals(sortierteListe.get(i))) team2 += sortierteListe.size()-i;
        }

        for(Spiel spiel : last5GamesHeim) {
            int tore;
            int toreGegner;

            if(spiel.getHeimteam().equals(spielQuote.getHeimteam())) {tore=spiel.getHeimtore(); toreGegner=spiel.getAuswaertstore();
            if(tore==toreGegner) team1+=1;
            if(tore>toreGegner) team1+=3;
            }
            else {toreGegner=spiel.getHeimtore(); tore=spiel.getAuswaertstore();
                if(tore==toreGegner) team1+=1;
                if(tore<toreGegner) team1+=3;}
        }

        for(Spiel spiel : last5GamesAus) {
            int tore;
            int toreGegner;

            if(spiel.getHeimteam().equals(spielQuote.getHeimteam())) {tore=spiel.getHeimtore(); toreGegner=spiel.getAuswaertstore();
                if(tore==toreGegner) team2+=1;
                if(tore>toreGegner) team2+=3;
            }
            else {toreGegner=spiel.getHeimtore(); tore=spiel.getAuswaertstore();
                if(tore==toreGegner) team2+=1;
                if(tore<toreGegner) team2+=3;}
        }

        quoten.setHeim(1.0 +  team1/ team2);
        quoten.setAuswaerts(1.0 + team2 / team1);
        quoten.setUnentschieden((quoten.getAuswaerts()+quoten.getHeim())/2);
        return quoten;
    }

    public void zulassungEntscheiden(Long erlaubnisID, boolean ant) throws Exception{
        Optional<Wetterlaubnis> erlaubnis = wettErlaubnisRepository.findById(erlaubnisID);
        if(erlaubnis.isEmpty()) throw new Exception("");
        erlaubnis.get().setEntscheidung(ant);
        wettErlaubnisRepository.save(erlaubnis.get());
        userRepository.updateErlaubnis(ant, erlaubnis.get().getBenutzerID());
    }

    public void wettzulassungsAnfrage(Long id) throws Exception {
        List<Benutzer> admins = userRepository.findAdmins();
        Optional<Benutzer> benutzer = userRepository.findById(id);
        LocalDate sysTime = configService.getSysTime();
        if(benutzer.isEmpty() || benutzer.get().isWetterlaubnis()) throw new Exception("");
        if(java.time.temporal.ChronoUnit.DAYS.between(benutzer.get().getGeburtsdatum(), sysTime)<6570) throw new Exception("Unter 18");
        for(Benutzer admin : admins) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(admin.getEmail());
            message.setFrom("KicktippEmailGruppeG@gmail.com");
            message.setSubject("Wetterlaubnisanfrage von " + benutzer.get().getEmail());
            message.setText("http://localhost/");
            mailSender.send(message);
        }
        Wetterlaubnis erlaubnis = new Wetterlaubnis();
        erlaubnis.setBenutzerID(id);
        wettErlaubnisRepository.save(erlaubnis);

    }

    public Wetterlaubnis getWettErlaubnis(Long benutzerID) {
        Wetterlaubnis wetterlaubnis = wettErlaubnisRepository.findWetterlaubnisByBenutzerID(benutzerID);
        if(!wetterlaubnis.isEntscheidung()) return null;
        wettErlaubnisRepository.deleteById(wetterlaubnis.getId());
        return wetterlaubnis;
    }

    public void addGeld(Long benutzerID, double geld) {
        userRepository.updateGeld(benutzerID, geld);
    }
}
