package com.kicktipp.server.service;

import com.kicktipp.server.model.Benutzer;
import com.kicktipp.server.model.Freundschaftsanfragen;
import com.kicktipp.server.repository.FreundRepository;
import com.kicktipp.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FreundService {

    @Autowired
    FreundRepository freundRepository;

    @Autowired
    UserRepository userRepository;

    public void createFreundschaftsanfrage(Freundschaftsanfragen anfrage) { anfrage.setId(null); freundRepository.save(anfrage); }

    public void deleteFreund(Long benutzerIDFreund, Long benutzerIDAnfrage) throws Exception {
        freundRepository.deleteFreund(benutzerIDFreund, benutzerIDAnfrage);
    }

    public List<Benutzer> getFreunde(Long benutzerID) { return userRepository.getFreundeByID(benutzerID); }

    public List<Freundschaftsanfragen> offeneFreundschaftsanfragen(Long benutzerID) { return freundRepository.findOffeneFreundschaftsanfragen(benutzerID); }

    public List<Benutzer> offeneFreunde(Long freundID) { return userRepository.findOffeneFreunde(freundID); }

    public void anfrageAnnehmen(Long freundID, Long benutzerID) {
        freundRepository.freundAnnehmen(freundID, benutzerID);
    }

    public List<Benutzer> getNutzerOhneFreunde(Long benutzerID) {
        return userRepository.findNutzerOhneFreund(benutzerID);
    }

    public Benutzer getUserDetails(Long id) throws Exception{
        Optional<Benutzer> user = userRepository.findById(id);
        if(user.isEmpty()) throw new Exception();
        user.get().setPasswort(null);
        user.get().setAuthtoken(null);
        return user.get();
    }
}
