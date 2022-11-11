package com.kicktipp.server.service;
import com.kicktipp.server.model.Liga;
import com.kicktipp.server.model.Spiel;
import com.kicktipp.server.repository.LigaRepository;
import com.kicktipp.server.repository.SpielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LigaService {
    @Autowired
    LigaRepository ligaRepository;

    @Autowired
    SpielRepository spielRepository;

    public Iterable<Liga> getAllLeagues() {
        return ligaRepository.findAll();
    }

    public List<Spiel> getGamesInLeague(Long id) {
        return spielRepository.findAllByLigaFremdschlussel(id);
    }

    public Iterable<Spiel> getGamesByDate(Date date) {
        return spielRepository.findAllByDatum(date);
    }

    public void updateLeaguePicture() {
        ;
    }

    public Liga addLeague(Liga league) {
        return ligaRepository.save(league);
    }

    public Spiel addGame(Spiel game) {
        return spielRepository.save(game);
    }

    public Optional<Liga> getLigaById(Long id) { return ligaRepository.findById(id); }

    public List<Spiel> getAllGamesByLeague(Long id) { return spielRepository.findAllByLigaFremdschlussel(id); }
}
