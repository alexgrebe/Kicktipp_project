package com.kicktipp.server.controller;

import com.kicktipp.server.model.Configuration;
import com.kicktipp.server.service.AuthService;
import com.kicktipp.server.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80"}, allowCredentials = "true")
public class ConfigController {

    @Autowired
    ConfigService service;

    @Autowired
    AuthService authService;

    @GetMapping("/getConfigAttributes")
    public Iterable<Configuration> getConfigAttributes() {
        return service.getAllAttributes();
    }

    @PostMapping("/addConfigAttribute")
    public String addConfigAttribute(@RequestBody Configuration configuration, @CookieValue("auth_token") String token) {
        if(token==null) return "Missing Token";
        if(authService.RoleByToken(token).equals("admin")) {
            service.addAttribute(configuration);
            return "success"; }
        return "";
    }

    @PostMapping("/updateConfig/{id}")
    public String updateConfig(@PathVariable Long id, @RequestBody String value, @CookieValue("auth_token") String token) {
        if(authService.RoleByToken(token).equals("admin")) { service.updateValueByAttribute(id, value); return "success";}
        return "";
    }

}
