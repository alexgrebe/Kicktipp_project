package com.kicktipp.server.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @GetMapping("/userById")
    public String userById() {
        return "jssjjs";
    }

    @GetMapping("/")
    public String hallo() {
        return "asssass";
    }
}
