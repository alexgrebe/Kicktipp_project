package com.kicktipp.server.controller;

import com.kicktipp.server.service.AuthService;
import com.kicktipp.server.service.WetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80", "http://localhost"}, allowCredentials = "true")
@RestController
public class WettenController {

    @Autowired
    private AuthService authService;
    @Autowired
    private WetteService wetteService;

}
