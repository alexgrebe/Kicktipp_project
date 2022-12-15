package com.kicktipp.server.controller;

import com.kicktipp.server.model.Liga;
import com.kicktipp.server.model.Mitglied;
import com.kicktipp.server.model.Spiel;
import com.kicktipp.server.service.AuthService;
import com.kicktipp.server.service.ConfigService;
import com.kicktipp.server.service.LigaService;
import com.kicktipp.server.service.TipprundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80", "http://localhost"}, allowCredentials = "true")
public class LigaController {

    @Autowired
    LigaService service;

    @Autowired
    AuthService authService;

    @Autowired
    ConfigService configService;

    @Autowired
    TipprundeService tipprundeService;

    @GetMapping("/getAllLeagues")
    public ResponseEntity<Iterable<Liga>> getAllLigen(@CookieValue(value = "auth_token", required = false) String token) {
        try{
            if(token==null||!authService.verifyToken(token)) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(service.getAllLeagues(), HttpStatus.ACCEPTED);}
        catch(Exception e) { return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);}
    }

    @PostMapping("/addLiga")
    public ResponseEntity<String> addLiga(@RequestBody Liga liga, @CookieValue(value = "auth_token", required = false) String token) {
        try {
            if (token == null || !authService.RoleByToken(token).equals("admin"))
                return new ResponseEntity<>("Failed!", HttpStatus.UNAUTHORIZED);
            service.addLeague(liga);
            return new ResponseEntity<>("", HttpStatus.ACCEPTED);
        }
        catch(Exception e) { return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);}
    }

    @PostMapping("/addGame")
    public ResponseEntity<String> addGame(@RequestBody Spiel spiel, @CookieValue(value = "auth_token", required = false) String token) {
        try{
        if (token == null || !authService.RoleByToken(token).equals("admin")) return new ResponseEntity<>("Failed!", HttpStatus.UNAUTHORIZED);
        service.addGame(spiel);
            return new ResponseEntity<>("", HttpStatus.ACCEPTED);}
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllGamesByLeague/{id}")
    public ResponseEntity<List<Spiel>> spieleListe(@PathVariable Long id, @CookieValue(value = "auth_token", required = false) String token) {
        try {
            if (token == null || !authService.verifyToken(token))
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(service.getAllGamesByLeague(id), HttpStatus.ACCEPTED);
        }
        catch(Exception e) {return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);}
        }

    @PostMapping("/readInCSV/{id}")
    public ResponseEntity<String> csvController(@PathVariable Long id, @RequestBody MultipartFile file, @CookieValue(value = "auth_token", required = false) String token) {
        try{
        if (token == null || !authService.RoleByToken(token).equals("admin")) return new ResponseEntity<>("Failed!", HttpStatus.UNAUTHORIZED);
        service.readCSV(new BufferedReader(new InputStreamReader(file.getInputStream())), id);
                return new ResponseEntity<>("", HttpStatus.ACCEPTED);
        }
        catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }

    @GetMapping("/deleteGame/{spielID}")
    public ResponseEntity<String> deleteGame(@PathVariable("spielID") Long spielID, @CookieValue(value = "auth_token" ,required = false) String token) {
        try{
            if(token == null || !authService.RoleByToken(token).equals("admin")) return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
            service.deleteGame(spielID);
            return new ResponseEntity<>("", HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/ligaUpdate")
    public ResponseEntity<String> updateLiga(@CookieValue(value = "auth_token", required = false) String token, @RequestBody Liga liga) {
        try {
            if(token == null || !authService.RoleByToken(token).equals("admin"))
                return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
            service.updateLiga(liga);
        return new ResponseEntity<>("", HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        }

    @GetMapping("/offeneSpiele/{tipprundenID}")
    public ResponseEntity<List<Spiel>> offeneSpiele(@CookieValue(value = "auth_token", required = false)String token, @PathVariable Long tipprundenID) {
        try{
            if(token==null || !authService.verifyToken(token))
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            Mitglied mitgliedzws = tipprundeService.getMitgliedByBenutzerIDAndTipprundenID(authService.findIdByAuthtoken(token), tipprundenID);
            List<Spiel> spiele = service.getGamesByDate(configService.getSysTime(), tipprundenID,
                    mitgliedzws.getId());
            return new ResponseEntity<>(spiele,
                    HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    }



