package com.kicktipp.server.controller;

import com.kicktipp.server.model.Liga;
import com.kicktipp.server.model.Spiel;
import com.kicktipp.server.service.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LigaController {

    @Autowired
    LigaService service;

    @GetMapping("/getAllLeagues")
    public Iterable<Liga> getAllLigen() {
        return service.getAllLeagues();
    }

    @PostMapping("/addLiga")
    public String addLiga(@RequestBody Liga liga) {
        service.addLeague(liga);
        return "success";
    }

    @PostMapping("/addGame")
    public String addGame(@RequestBody Spiel spiel) {
        service.addGame(spiel);
        return "success";
    }
}
