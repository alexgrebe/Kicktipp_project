package com.kicktipp.server.controller;

import com.kicktipp.server.model.Benutzer;
import com.kicktipp.server.model.Freundschaftsanfragen;
import com.kicktipp.server.service.AuthService;
import com.kicktipp.server.service.FreundService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/freunde")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80", "http://localhost"}, allowCredentials = "true")
public class FreundController {

    @Autowired
    FreundService freundService;

    @Autowired
    AuthService authService;

    @PostMapping("/create")
    public ResponseEntity<String> createFreundschaftsanfrage(@CookieValue(value = "auth_token", required = false) String token, @RequestBody Freundschaftsanfragen anfrage) {
        try {
            if (token==null || !authService.verifyToken(token)) return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
            anfrage.setSender(authService.findIdByAuthtoken(token));
            freundService.createFreundschaftsanfrage(anfrage);
            return new ResponseEntity<>("", HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/delete/{benutzerID}")
    public ResponseEntity<String> deleteFreund(@CookieValue(value = "auth_token", required = false) String token, @PathVariable Long benutzerID) {
        try{
            if (token==null || !authService.verifyToken(token)) return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
            freundService.deleteFreund(benutzerID, authService.findIdByAuthtoken(token));
            return new ResponseEntity<>("", HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/anzeigen")
    public ResponseEntity<List<Benutzer>> freundeAnzeigen(@CookieValue(value = "auth_token", required = false) String token) {
        try{
            if (token==null || !authService.verifyToken(token)) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            List<Benutzer> freunde = freundService.getFreunde(authService.findIdByAuthtoken(token));
            return new ResponseEntity<>(freunde, HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
