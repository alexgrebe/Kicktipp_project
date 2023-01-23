package com.kicktipp.server.controller;

import com.kicktipp.server.model.*;
import com.kicktipp.server.service.AuthService;
import com.kicktipp.server.service.LigaService;
import com.kicktipp.server.service.WetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80", "http://localhost"}, allowCredentials = "true")
@RestController
public class WettenController {

    @Autowired
    private AuthService authService;
    @Autowired
    private WetteService wetteService;
    @Autowired
    private LigaService ligaService;

    @PostMapping("/createWette")
    public ResponseEntity<String> createWette(@CookieValue(value = "auth_token", required = false)String token, @RequestBody Wette wette) {
        try{
        if(token == null || !authService.verifyToken(token)) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
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
            if(token == null || !authService.verifyToken(token)) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            Long id = authService.findIdByAuthtoken(token);
            wetteService.wettzulassungsAnfrage(id);
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/erlaubnis/{id}")
    public ResponseEntity<String> erlaubnisAnnehmenAblehnen(@CookieValue(value = "auth_token", required = false)String token, @PathVariable Long id, @RequestParam("entscheidung") boolean entscheidung ) {
        try{
            if(token==null || !authService.RoleByToken(token).equals("admin")) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            wetteService.zulassungEntscheiden(id, entscheidung);
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getErlaubnis")
    public ResponseEntity<Wetterlaubnis> getErlaubnis(@CookieValue(value = "auth_token", required = false)String token) {
        try{
            if(token==null || !authService.verifyToken(token)) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            Long benutzerID = authService.findIdByAuthtoken(token);
            Wetterlaubnis erlaubnis = wetteService.getWettErlaubnis(benutzerID);
            return new ResponseEntity<>(erlaubnis, HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getQuotenForGame/{spielID}")
    public ResponseEntity<Quoten> getQuoten(@CookieValue(value = "auth_token", required = false)String token, @PathVariable Long spielID) {
        try{
            if(token == null || !authService.verifyToken(token)) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            Optional<Spiel> spiel = ligaService.getSpiel(spielID);
            Quoten quoten = wetteService.quoteBerechnen(spiel.get());
            return new ResponseEntity<>(quoten, HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/addGeld")
    public ResponseEntity<String> addGeld(@CookieValue(value = "auth_token", required = false)String token, @RequestParam("geld") int geld) {
        try{
            if(token==null||!authService.verifyToken(token)) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            wetteService.addGeld(authService.findIdByAuthtoken(token), geld);
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllErlaubnis")
    public ResponseEntity<List<Benutzer>> erlaubnisAnfragen(@CookieValue(value = "auth_token", required = false) String token) {
        try{
            if(token==null || !authService.RoleByToken(token).equals("admin")) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            List<Benutzer> benutzer = wetteService.alleOfeneEntscheidungen();
            for(Benutzer user : benutzer) {
                user.setPasswort(null);
                user.setProfilepicturedata(null);
            }
            return new ResponseEntity<>(benutzer, HttpStatus.ACCEPTED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("entscheidungByBenutzer/{id}")
    public ResponseEntity<String> erlaubnisBenutzerAnAb(@CookieValue(value = "auth_token", required = false)String token, @PathVariable Long id, @RequestParam("entscheidung")boolean entscheidung) {
        try{
            if(token == null || !authService.RoleByToken(token).equals("admin")) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            wetteService.entscheidungWetterlaubnis(id, entscheidung);
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
