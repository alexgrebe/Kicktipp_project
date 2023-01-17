package com.kicktipp.server.service;

import com.kicktipp.server.model.Configuration;
import com.kicktipp.server.model.Spiel;
import com.kicktipp.server.model.Wette;
import com.kicktipp.server.repository.ConfigRepository;
import com.kicktipp.server.repository.SpielRepository;
import com.kicktipp.server.repository.UserRepository;
import com.kicktipp.server.repository.WetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ConfigService {
    @Autowired
    ConfigRepository repo;

    @Autowired
    WetteRepository wetteRepository;

    @Autowired
    SpielRepository spielRepository;

    @Autowired
    UserRepository userRepository;

    public void updateSysTime(LocalDate date) {
        repo.updateSysTime(repo.findAll().iterator().next().getId(), date);
        Iterable<Wette> wetten = wetteRepository.findAll();
        for(Wette wette : wetten) {
            Optional<Spiel> spiel = spielRepository.findById(wette.getSpielID());
            if(spiel.isEmpty()) { spielRepository.deleteById(spiel.get().getId()); continue; }
            if(spiel.get().getDatum().isBefore(date)) {
                Wette.Auswahl auswahl = null;
                if(spiel.get().getHeimtore()-spiel.get().getAuswaertstore()<0) auswahl = Wette.Auswahl.AUSWAERTS;
                if(spiel.get().getHeimtore()-spiel.get().getAuswaertstore()==0) auswahl = Wette.Auswahl.UNENTSCHIEDEN;
                if(spiel.get().getHeimtore()-spiel.get().getAuswaertstore()>0) auswahl = Wette.Auswahl.HEIM;

                if(wette.getAuswahl()==auswahl) userRepository.updateGeld(wette.getBenutzerID(), wette.getEinsatz()*wette.getQuote());
                wetteRepository.deleteById(wette.getId());
            }
        }
    }

    public LocalDate getSysTime() {
        return repo.findAll().iterator().next().getSysTime();
    }

}
