package com.kicktipp.server.controller;

import com.kicktipp.server.model.Liga;
import com.kicktipp.server.model.Spiel;
import com.kicktipp.server.service.AuthService;
import com.kicktipp.server.service.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class LigaController {

    @Autowired
    LigaService service;

    @Autowired
    AuthService authService;

    @GetMapping("/getAllLeagues")
    public Iterable<Liga> getAllLigen() {
    return service.getAllLeagues();
    }

    @PostMapping("/addLiga")
    public String addLiga(@RequestBody Liga liga, @CookieValue("auth_token") String token) {
        if(token==null) return "Missing Token";
        if(authService.RoleByToken(token).equals("admin")) {
        service.addLeague(liga);
        return "success"; }
        return "";
    }

    @PostMapping("/addGame")
    public String addGame(@RequestBody Spiel spiel, @CookieValue("auth_token") String token) {
        if(token==null) return "Missing Token";
        if(authService.RoleByToken(token).equals("admin")){
        service.addGame(spiel);
        return "success";}
        return "";
    }

    @GetMapping("/getAllGamesByLeague/{id}")
    public List<Spiel> spieleListe(@PathVariable Long id) {
        return service.getAllGamesByLeague(id);
    }

    @PostMapping("/readInCSV/{id}")
    public String csvController(@PathVariable Long id, @RequestBody MultipartFile file, @CookieValue("auth_token") String token) {
        if(token==null) return "Missing Token";
        if(authService.RoleByToken(token).equals("admin")) {
        try{
        service.readCSV(new BufferedReader(new InputStreamReader(file.getInputStream())), id);
        return "success";
        }
        catch(Exception e) {
        return e.getMessage();} }
        return "";
    }
}
