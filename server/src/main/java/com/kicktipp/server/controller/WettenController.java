package com.kicktipp.server.controller;

import com.kicktipp.server.model.Benutzer;
import com.kicktipp.server.model.Wette;
import com.kicktipp.server.service.AuthService;
import com.kicktipp.server.service.WetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80", "http://localhost"}, allowCredentials = "true")
@RestController
public class WettenController {

    @Autowired
    private AuthService authService;
    @Autowired
    private WetteService wetteService;

    @PostMapping("/createWette")
    public ResponseEntity<String> createWette(@CookieValue(value = "auth_token", required = false)String token, @RequestBody Wette wette) {
        try{
        if(token == null || authService.verifyToken(token)) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        Benutzer b = authService.getUserDetailsByToken(token);
        wetteService.createWette(wette, b);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/erlaubnis")
    public ResponseEntity<String> erlaubnisAnfrage(@CookieValue(value = "auth_token", required = false) String token) {
        try{
            if(token == null || authService.verifyToken(token)) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            Long id = authService.findIdByAuthtoken(token);
            wetteService.wettzulassungsAnfrage(id);
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/erlaubnis/{id}")
    public ResponseEntity<String> erlaubnisAnnehmenAblehnen() {
        return null;
    }
}
