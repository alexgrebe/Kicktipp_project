package com.kicktipp.server.service;

import com.kicktipp.server.model.Mitglied;
import com.kicktipp.server.model.Tipp;
import com.kicktipp.server.model.Tipprunde;
import com.kicktipp.server.repository.MitgliedRepository;
import com.kicktipp.server.repository.TippRepository;
import com.kicktipp.server.repository.TipprundeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipprundeService {

    @Autowired
    TipprundeRepository tipprundenRepo;

    @Autowired
    TippRepository tippRepo;

    @Autowired
    MitgliedRepository mitgliedRepo;

    public void createTipprunde(Tipprunde tipprunde) {
        tipprunde.setId(null);
        tipprundenRepo.save(tipprunde);
    }

    public void addMitglied(Mitglied mitglied) {
        mitglied.setId(null);
        mitgliedRepo.save(mitglied);
    }

    public List<Tipprunde> getTipprunden(Long benutzerID) {
        return tipprundenRepo.findTipprunde(benutzerID);
    }

    public List<Tipprunde> getMyTipprunden(Long benutzerID) {
        return tipprundenRepo.findMyTipprunde(benutzerID);
    }

    public List<Tipp> getMyTipps(Long mitgliedID) {
        return tippRepo.findMyTipps(mitgliedID);
    }

    public void createTipp(Tipp tipp) {
        tipp.setId(null);
        tippRepo.save(tipp);
    }

    public List<Tipp> getMyTippsForGame(Long mitgliedID, Long spielID) {
        return tippRepo.findMyTippsByGame(mitgliedID, spielID);
    }

    public void sendInvite(Long tipprundenID, Long empfangerID) {
        //TODO
    }

    public void shareTipp(Long tippID, Long benutzerID) {
        //TODO
    }

    public void changeMitgliedName(Long mitgliedID, String name) {
        mitgliedRepo.changeMitgliedName(name, mitgliedID);
    }

    public void tipprundeBeitreten(Long benutzerID, Long tipprundenID, String passwort) throws Exception{
        if(!tipprundenRepo.findTipprundeById(tipprundenID).getPasswort().equals(passwort)) throw new Exception("Falsches Passwort!");
        Mitglied mitglied = new Mitglied();
        mitglied.setTipprundeID(tipprundenID);
        mitglied.setBenutzerID(benutzerID);
        mitglied.setName("Neues Mitglied " + Math.random() * 1000);
        mitgliedRepo.save(mitglied);
    }

}
