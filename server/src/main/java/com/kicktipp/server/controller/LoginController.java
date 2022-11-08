package com.kicktipp.server.controller;

import com.kicktipp.server.model.Login;
import com.kicktipp.server.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin("*")
public class LoginController {

    @Autowired
    AuthService service;

    @PostMapping("/login")
    public String loginControll(HttpServletResponse HttpRes, @RequestBody Login body) {
        String token = service.login(body.getEmail(), body.getPasswort());
        if(token==null) return "failure";
        HttpRes.addCookie(new Cookie("auth_token", token));
        return "success";
    }

}
