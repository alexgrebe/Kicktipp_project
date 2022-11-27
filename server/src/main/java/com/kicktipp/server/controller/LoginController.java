package com.kicktipp.server.controller;

import com.kicktipp.server.model.Login;
import com.kicktipp.server.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80", "http://localhost"}, allowCredentials = "true")
public class LoginController {

    @Autowired
    AuthService service;

    @PostMapping("/login")
    public ResponseEntity<String> loginControll(HttpServletResponse HttpRes, @RequestBody Login body) {
        try {
            String token = service.login(body.getEmail(), body.getPasswort());
            if (token == null) throw new Exception("Not valid");
            HttpRes.addCookie(new Cookie("auth_token", token));
            return new ResponseEntity<>(service.RoleByToken(token), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("failure", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getRole")
    public ResponseEntity<String> getRole(@CookieValue("auth_token") String token) {
        try {
            return new ResponseEntity<>(service.RoleByToken(token), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
