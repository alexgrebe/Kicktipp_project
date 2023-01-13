package com.kicktipp.server.service;

import com.kicktipp.server.model.Benutzer;
import com.kicktipp.server.model.Wette;
import com.kicktipp.server.repository.WetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WetteService {

    @Autowired
    private WetteRepository wetteRepository;

    public void createWette(Wette wette, Benutzer b) throws Exception {
        if(b.getGeld()<wette.getEinsatz() || !b.isWetterlaubnis() ) throw new Exception("");
        wetteRepository.save(wette);
    }

    public void zulassungEntscheiden() {}

    public void wettzulassungsAnfrage() {}
}
