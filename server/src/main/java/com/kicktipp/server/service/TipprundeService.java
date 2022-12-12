package com.kicktipp.server.service;

import com.kicktipp.server.model.*;
import com.kicktipp.server.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TipprundeService {

    @Autowired
    TipprundeRepository tipprundenRepo;

    @Autowired
    TippRepository tippRepo;

    @Autowired
    MitgliedRepository mitgliedRepo;

    @Autowired
    ConfigRepository configRepo;

    @Autowired
    SpielRepository spielRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    JavaMailSender mailSender;

    public void createTipprunde(Tipprunde tipprunde) {
        tipprunde.setId(null);
        tipprundenRepo.save(tipprunde);
    }

    public void addMitglied(Mitglied mitglied) {
        mitglied.setId(null);
        mitgliedRepo.save(mitglied);
    }

    public List<Tipprunde> getTipprunden(Long benutzerID) {

        System.out.println(benutzerID);
        return tipprundenRepo.findTipprunde(benutzerID);
    }

    public List<Tipprunde> getMyTipprunden(Long benutzerID) {
        return tipprundenRepo.findMyTipprunde(benutzerID);
    }

    public List<Tipp> getMyTipps(Long mitgliedID) {
        return tippRepo.findMyTipps(mitgliedID);
    }

    public void createTipp(Tipp tipp) throws Exception {
        if(spielRepo.findById(tipp.getSpielID()).get().getDatum().isAfter(configRepo.findAll().iterator().next().getSysTime())) throw new Exception("Spiel bereits vorbei!");
        tipp.setId(null);
        tippRepo.save(tipp);
    }

    public List<Tipp> getMyTippsForGame(Long benutzerID, Long spielID) {
        return tippRepo.findMyTippsByGame(benutzerID, spielID);
    }

    public void sendInvite(Long tipprundenID, Long empfangerID) throws Exception {
        Tipprunde runde = tipprundenRepo.findTipprundeById(tipprundenID);
        Optional<Benutzer> empfanger = userRepo.findById(empfangerID);
        if(runde == null || empfanger.isEmpty()) throw new Exception();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("KicktippEmailGruppeG@gmail.com");
        message.setSubject("Einladung zur Tipprunde");
        message.setTo(empfanger.get().getEmail());
        message.setText("Einladung zur Tipprunde: "+runde.getName()+" Link zum Beitreten: "+ "http://localhost/beitreten/"+runde.getId());
        mailSender.send(message);

    }

    public void shareTipp(Long tippID, Long benutzerID) throws Exception {
        List<String> emails = userRepo.findFreundeEmailsById(benutzerID);
        Optional<Benutzer> benutzer = userRepo.findById(benutzerID);
        Optional<Tipp> tipp = tippRepo.findById(tippID);
        Optional<Spiel> spiel = spielRepo.findById(tipp.get().getSpielID());
        if(benutzer.isEmpty() || tipp.isEmpty() || spiel.isEmpty()) throw new Exception();
        for(String email : emails) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setFrom("KicktippEmailGruppeG@gmail.com");
            message.setSubject(benutzer.get().getVorname() + " hat einen Tipp mit dir geteilt");
            message.setText(benutzer.get().getVorname() + " hat getippt, dass das Spiel "
                    + spiel.get().getHeimteam() + " gegen " + spiel.get().getAuswaertsteam() + ", " + spiel.get().getHeimtore() + " zu " +
                    spiel.get().getAuswaertstore() + "endet.");
            mailSender.send(message);
        }
    }

    public void changeMitgliedName(Long mitgliedID, String name) {
        mitgliedRepo.changeMitgliedName(name, mitgliedID);
    }

    public void tipprundeBeitreten(Long benutzerID, Long tipprundenID, String passwort) throws Exception{
        if(!tipprundenRepo.findTipprundeById(tipprundenID).getPasswort().equals(passwort)) throw new Exception("Falsches Passwort!");
        Mitglied mitglied = new Mitglied();
        mitglied.setTipprundeID(tipprundenID);
        mitglied.setBenutzerID(benutzerID);
        mitglied.setName("Neues Mitglied " + (int)(Math.random() * 1000));
        mitgliedRepo.save(mitglied);
    }

    public List<Mitglied> getTipprundenMitglieder(Long id) {
        List<Mitglied> mitglieder = mitgliedRepo.getMitgliedByTipprundenID(id);
        Tipprunde tipprunde = tipprundenRepo.findTipprundeById(id);
        LocalDate sysDate = configRepo.findAll().iterator().next().getSysTime();

        for(Mitglied mitglied : mitglieder) {
            List<Tipp> tipps = tippRepo.findMyTippsByTipprunde(mitglied.getId());
            for(Tipp tipp : tipps) {
                Optional<Spiel> spiel = spielRepo.findById(tipp.getSpielID());
                if(spiel.isEmpty() || spiel.get().getDatum().isAfter(sysDate)) continue;
                //Tordiff
                if(Math.abs(spiel.get().getAuswaertstore()-spiel.get().getHeimtore()) ==
                        Math.abs(tipp.getToreAus()-tipp.getToreHeim()))
                    mitglied.setPunkte(mitglied.getPunkte()+tipprunde.getTordiffgewicht());
                //Sieger
                if(
                        (spiel.get().getAuswaertstore()-spiel.get().getHeimtore()>0 ==
                        tipp.getToreAus()-tipp.getToreHeim()>0) ||
                                (tipp.getToreAus()-tipp.getToreHeim()==0 && spiel.get().getAuswaertstore()-spiel.get().getHeimtore()==0))
                    mitglied.setPunkte(mitglied.getPunkte()+tipprunde.getSiegergewicht());
                //Ergebnis
                if(spiel.get().getHeimtore()==tipp.getToreHeim() && spiel.get().getAuswaertstore()==tipp.getToreAus())
                    mitglied.setPunkte(tipprunde.getErgebnisgewicht()+mitglied.getPunkte());
            }
        }
        return mitgliedRepo.getMitgliedByTipprundenID(id);
    }

    public Long getBenutzerIDByMitgliedID(Long mitgliedID) {
        return mitgliedRepo.findBenutzerIDById(mitgliedID);
    }

    public Tipprunde getTipprundeById(Long tipprundenID) {
        return tipprundenRepo.findTipprundeById(tipprundenID);
    }

    public Mitglied getMitgliedByBenutzerIDAndTipprundenID(Long benutzerID, Long tipprundenID) {
        return mitgliedRepo.findMitgliedByTipprundenIDAndBenutzerID(benutzerID, tipprundenID);
    }
}
