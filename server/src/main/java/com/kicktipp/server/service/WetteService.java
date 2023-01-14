package com.kicktipp.server.service;

import com.kicktipp.server.model.Benutzer;
import com.kicktipp.server.model.Spiel;
import com.kicktipp.server.model.Wette;
import com.kicktipp.server.model.Wetterlaubnis;
import com.kicktipp.server.repository.SpielRepository;
import com.kicktipp.server.repository.UserRepository;
import com.kicktipp.server.repository.WettErlaubnisRepository;
import com.kicktipp.server.repository.WetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    JavaMailSender mailSender;

    public void createWette(Wette wette, Benutzer b) throws Exception {
        if(b.getGeld()<wette.getEinsatz() || !b.isWetterlaubnis() ) throw new Exception("");
        List<Spiel> spiele = spielRepository.findAllGamesPlayedInALeagueBeforeDate(wette.getSpielID());
        //TODO QUOTE
        wetteRepository.save(wette);
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
        if(benutzer.isEmpty() || benutzer.get().isWetterlaubnis()) throw new Exception("");
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
        wettErlaubnisRepository.deleteById(wetterlaubnis.getId());
        return wetterlaubnis;
    }
}
