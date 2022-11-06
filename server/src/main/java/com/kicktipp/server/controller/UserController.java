package com.kicktipp.server.controller;

import com.kicktipp.server.model.Benutzer;
import com.kicktipp.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/userById")
    public String userById() {
        return "jssjjs";
    }

    @GetMapping("/")
    public String hallo() {
        return "asssass";
    }

    @PostMapping("/addUser")
    public String addUserController(@RequestBody Benutzer benutzer) {
        try{
        Benutzer ret = service.addUser(benutzer);
        System.out.println(ret.getId());
        return "success";}
        catch(Exception e) {return e.getMessage();}
    }

    @GetMapping("/getAllUsers")
    public Iterable<Benutzer> getAllUsersController() {
        return service.getAllUsers();
    }
}
