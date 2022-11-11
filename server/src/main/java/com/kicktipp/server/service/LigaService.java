package com.kicktipp.server.service;
import com.kicktipp.server.model.Liga;
import com.kicktipp.server.model.Spiel;
import com.kicktipp.server.repository.LigaRepository;
import com.kicktipp.server.repository.SpielRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LigaService {
    @Autowired
    LigaRepository ligaRepository;

    @Autowired
    SpielRepository spielRepository;

    public void readCSV(BufferedReader input) throws IOException, CsvException {
        CSVReader reader = new CSVReader(input);
        List<String[]> parsedLines;
        parsedLines = reader.readAll();

        if (parsedLines.remove(0).length != 5) {
            throw new IOException();
        }
        for (String[] parsedLine : parsedLines) {
            Spiel spiel = new Spiel();
            spiel.setSpieltag(Integer.getInteger(parsedLine[0]));
            // todo ich hab keine Ahnung warum das Format nicht passt, in groovy mit dem gleichen code funktioniert das
            spiel.setDatum(LocalDate.parse(parsedLine[1], DateTimeFormatter.ofPattern("EEE LLL d uuuu")));
            spiel.setHeimteam(parsedLine[2]);
            spiel.setHeimtore(Integer.parseInt(parsedLine[3].split("-")[0]));
            spiel.setAuswaertstore(Integer.parseInt(parsedLine[3].split("-")[1]));
            spiel.setAuswaertsteam(parsedLine[4]);

            spielRepository.save(spiel);
        }

    }

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
