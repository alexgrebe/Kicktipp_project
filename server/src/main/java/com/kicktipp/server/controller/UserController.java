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

    @PostMapping("/addUser")
    public String addUserController(@RequestBody Benutzer benutzer) {
        try{
        Benutzer ret = service.addUser(benutzer);
        if(!service.validateEmail(benutzer.email)) { throw new Exception("Email not valid"); }
        System.out.println(ret.getId());
        return "success";}
        catch(Exception e) {return e.getMessage();}
    }

    @GetMapping("/getAllUsers")
    public Iterable<Benutzer> getAllUsersController() {
        return service.getAllUsers();
    }
}
