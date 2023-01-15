package com.kicktipp.server.controller;

import com.kicktipp.server.model.Benutzer;
import com.kicktipp.server.service.AuthService;
import com.kicktipp.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80", "http://localhost"}, allowCredentials = "true")
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    AuthService authService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUserController(@RequestBody Benutzer benutzer) {
        try {
            Benutzer ret = service.addUser(benutzer);
            if (!service.validateEmail(benutzer.email)) {
                throw new Exception("Email not valid");
            }
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllUsers")
    public Iterable<Benutzer> getAllUsersController() {
        return service.getAllUsers();
    }

    @GetMapping("/getUserDetails")
    public ResponseEntity<Benutzer> getUserDetails(@CookieValue(value = "auth_token", required = false)String token) {
        try{
            if(token==null || !authService.verifyToken(token)) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            Long id = authService.findIdByAuthtoken(token);
            Optional<Benutzer> benutzer = service.getUserById(id);
            if(benutzer.isEmpty()) throw new Exception("");
            benutzer.get().setPasswort("");
            return new ResponseEntity<>(benutzer.get(), HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
