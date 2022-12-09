package com.kicktipp.server.controller;

import com.kicktipp.server.model.Mitglied;
import com.kicktipp.server.model.Tipp;
import com.kicktipp.server.model.Tipprunde;
import com.kicktipp.server.service.AuthService;
import com.kicktipp.server.service.TipprundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80", "http://localhost"}, allowCredentials = "true")
public class TipprundeController {

    @Autowired
    AuthService authService;

    @Autowired
    TipprundeService tipprundeService;

    @PostMapping("/createTipprunde")
    public ResponseEntity<String> createTipprunde(@CookieValue(value = "auth_token", required = false) String token, @RequestBody Tipprunde tipprunde) {
        try{
            if(token==null || !authService.verifyToken(token)) { return new ResponseEntity<>("Unauth", HttpStatus.UNAUTHORIZED); }
            tipprunde.setBesitzerID(authService.findIdByAuthtoken(token));
            System.out.println(tipprunde.getName());
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
            System.out.println(e.getMessage());
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

    @GetMapping("tipprunde/{tipprundenID}")
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

    @PostMapping("/tippErstellen/{tipprundenID}")
    public ResponseEntity<String> createTipp(@CookieValue(value = "auth_token", required = false) String token, @RequestBody() Tipp tipp) {
        try{
            if (token == null || !authService.verifyToken(token) ||
                    !(tipprundeService.getBenutzerIDByMitgliedID(tipp.getMitgliedID())==authService.findIdByAuthtoken(token)))
                return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
            tipprundeService.createTipp(tipp);
                return new ResponseEntity<>("", HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/sendInvite/{tipprundenID}/{empfangerID}")
    public ResponseEntity<String> inviteToTipprunde(@CookieValue(value = "auth_token", required = false) String token, @PathVariable("tipprundenID") Long tipprundenID, @PathVariable("empfangerID") Long empfangerID) {
        try{
            if(token == null || !authService.verifyToken(token) ||
                    !(tipprundeService.getTipprundeById(tipprundenID).getBesitzerID()==authService.findIdByAuthtoken(token)))
                return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
            tipprundeService.sendInvite(tipprundenID, empfangerID);
            return new ResponseEntity<>("", HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/shareTipp/{tippID}")
    public ResponseEntity<String> shareTipp(@CookieValue(value = "auth_token", required = false) String token, @PathVariable Long tippID) {
        try{
            if (token == null || !authService.verifyToken(token))
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            Long benutzerID = authService.findIdByAuthtoken(token);
            tipprundeService.shareTipp(tippID, benutzerID);
            return new ResponseEntity<>("", HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}