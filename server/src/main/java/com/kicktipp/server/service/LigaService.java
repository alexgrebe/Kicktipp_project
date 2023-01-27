package com.kicktipp.server.service;

import com.kicktipp.server.model.Liga;
import com.kicktipp.server.model.Spiel;
import com.kicktipp.server.repository.LigaRepository;
import com.kicktipp.server.repository.SpielRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class LigaService {
    @Autowired
    LigaRepository ligaRepository;

    @Autowired
    SpielRepository spielRepository;

    @Autowired
    ConfigService configService;

    public void readCSV(BufferedReader input, Long id) throws IOException, CsvException {
        CSVReader reader = new CSVReader(input);
        List<String[]> parsedLines;
        parsedLines = reader.readAll();

        if (parsedLines.remove(0).length != 5) {
            throw new IOException();
        }
        for (String[] parsedLine : parsedLines) {
            Spiel spiel = new Spiel();
            spiel.setLigaFremdschlussel(id);
            spiel.setSpieltag(Integer.parseInt(parsedLine[0]));
            DateTimeFormatter df = new DateTimeFormatterBuilder()
                    .parseCaseInsensitive()
                    .appendPattern("EEE MMM d yyyy")
                    .toFormatter(Locale.ENGLISH);
            spiel.setDatum(LocalDate.parse(parsedLine[1], df));
            spiel.setHeimteam(parsedLine[2]);
            if (parsedLine[3] != "") {
                spiel.setHeimtore(Integer.parseInt(parsedLine[3].split("-")[0]));
                spiel.setAuswaertstore(Integer.parseInt(parsedLine[3].split("-")[1]));
            } else {
                spiel.setHeimtore(null);
                spiel.setAuswaertstore(null);
            }
            spiel.setLigaFremdschlussel(id);
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

    public List<Spiel> getGamesByDate(LocalDate date, Long id, Long mitgliedID) {
        return spielRepository.findSpieleByDatumAndLiga(date, id, mitgliedID);
    }

    public List<Spiel> getGamesByDateLiga(Long ligaID) {
        List<Spiel> spiele = spielRepository.findAllGamesPlayedInALeagueBeforeDate(ligaID);
        for(Spiel spiel : spiele) {
        spiel.setHeimtore(null);
        spiel.setAuswaertstore(null);
        }
        return spiele;
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

    public Optional<Liga> getLigaById(Long id) {
        return ligaRepository.findById(id);
    }

    public List<Spiel> getAllGamesByLeague(Long id) {
        List<Spiel> spieleListe = spielRepository.findAllByLigaFremdschlussel(id);
        LocalDate sysTime = configService.getSysTime();
        for(Spiel spiel : spieleListe) {
            if(spiel.getDatum().isAfter(sysTime)) {
                spiel.setHeimtore(null);
                spiel.setAuswaertstore(null);
           }
        }
        return spieleListe;
    }

    public void deleteGame(Long id) {
        spielRepository.deleteById(id);
    }

    public void updateLiga(Liga liga) { ligaRepository.save(liga); }

    public Optional<Spiel> getSpiel(Long id) {return spielRepository.findById(id);}
}
