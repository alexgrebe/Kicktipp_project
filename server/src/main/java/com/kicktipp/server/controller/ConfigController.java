package com.kicktipp.server.controller;

import com.kicktipp.server.model.Configuration;
import com.kicktipp.server.service.AuthService;
import com.kicktipp.server.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80", "http://localhost"}, allowCredentials = "true")
public class ConfigController {

    @Autowired
    ConfigService service;

    @Autowired
    AuthService authService;
    
    @PostMapping("/updateSysTime")
    public ResponseEntity<String> updateSysTime(@RequestBody Configuration config, @CookieValue(value = "auth_token", required = false) String token) {
        try {
        if(token == null || !authService.RoleByToken(token).equals("admin")) return new ResponseEntity<>("Failed!", HttpStatus.UNAUTHORIZED);
        service.updateSysTime(config.sysTime);
        return new ResponseEntity<>("", HttpStatus.ACCEPTED);
    } catch(Exception e) { return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); }
    }

}
