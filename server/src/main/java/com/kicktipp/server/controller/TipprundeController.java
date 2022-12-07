package com.kicktipp.server.controller;

import com.kicktipp.server.model.Tipprunde;
import com.kicktipp.server.service.AuthService;
import com.kicktipp.server.service.TipprundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> addMitglied(@PathVariable("tipprundenID") Long tipprundenID, @RequestBody() String passwort) {
        return null;
    }
}
