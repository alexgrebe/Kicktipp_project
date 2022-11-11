package com.kicktipp.server.controller;

import com.kicktipp.server.model.Liga;
import com.kicktipp.server.model.Spiel;
import com.kicktipp.server.service.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
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

    @GetMapping("/getAllGamesByLeague/{id}")
    public List<Spiel> spieleListe(@PathVariable Long id) {
        return service.getAllGamesByLeague(id);
    }
}
