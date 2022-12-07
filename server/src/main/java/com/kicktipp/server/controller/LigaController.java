package com.kicktipp.server.controller;

import com.kicktipp.server.model.Liga;
import com.kicktipp.server.model.Spiel;
import com.kicktipp.server.service.AuthService;
import com.kicktipp.server.service.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
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
            if(token == null || !authService.verifyToken(token)) return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
            service.deleteGame(spielID);
            return new ResponseEntity<>("", HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    }

