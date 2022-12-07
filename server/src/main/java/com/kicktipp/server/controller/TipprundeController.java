package com.kicktipp.server.controller;

import com.kicktipp.server.model.Benutzer;
import com.kicktipp.server.model.Mitglied;
import com.kicktipp.server.model.Tipprunde;
import com.kicktipp.server.service.AuthService;
import com.kicktipp.server.service.TipprundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/tipprunden")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80", "http://localhost"}, allowCredentials = "true")
public class TipprundeController {

    @Autowired
    AuthService authService;

    @Autowired
    TipprundeService tipprundeService;

    @PostMapping("/createTipprunde")
    public ResponseEntity<String> createTipprunde(@CookieValue(value = "auth_token", required = false) String token, Tipprunde tipprunde) {
        try{
            if(token==null || !authService.verifyToken(token)) { return new ResponseEntity<>("Unauth", HttpStatus.UNAUTHORIZED); }
            tipprunde.setBesitzerID(authService.findIdByAuthtoken(token));
            tipprundeService.createTipprunde(tipprunde);
            return new ResponseEntity<>("", HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/beitreten/{tipprundenID}")
    public ResponseEntity<String> addMitglied(@PathVariable("tipprundenID") Long tipprundenID, @RequestBody() String passwort, @CookieValue(value = "auth_token", required = false) String token) {
        try{
            if(token == null || !authService.verifyToken(token)) return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
            tipprundeService.tipprundeBeitreten(authService.findIdByAuthtoken(token), tipprundenID, passwort);
            return new ResponseEntity<>("", HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/tipprundenAnzeigen")
    public ResponseEntity<List<Tipprunde>> getTipprunden(@CookieValue(value = "auth_token", required = false) String token) {
        try {
            if (token == null || !authService.verifyToken(token))
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            List<Tipprunde> runden = tipprundeService.getTipprunden(authService.findIdByAuthtoken(token));
            return new ResponseEntity<>(runden, HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/meineTipprunden")
    public ResponseEntity<List<Tipprunde>> getMyTipprunden(@CookieValue(value = "auth_token", required = false) String token) {
        try{
            if (token == null || !authService.verifyToken(token))
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            List<Tipprunde> runden = tipprundeService.getMyTipprunden(authService.findIdByAuthtoken(token));
            return new ResponseEntity<>(runden, HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{tipprundenID}")
    public ResponseEntity<List<Mitglied>> getTipprundenMitglieder(@PathVariable("tipprundenID") Long tipprundenID, @CookieValue(value = "auth_token", required = false) String token) {
        try {
            if (token == null || !authService.verifyToken(token))
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            List<Mitglied> mitglieder = tipprundeService.getTipprundenMitglieder(tipprundenID);
            return new ResponseEntity<>(mitglieder, HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        }
}
