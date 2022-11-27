package com.kicktipp.server.controller;

import com.kicktipp.server.model.Benutzer;
import com.kicktipp.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService service;

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
}
