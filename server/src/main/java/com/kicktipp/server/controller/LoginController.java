package com.kicktipp.server.controller;

import com.kicktipp.server.model.Login;
import com.kicktipp.server.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
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

    @GetMapping("/getRole")
    public String getRole(@CookieValue("auth_token") String token) {
        try{
            if(token==null) throw new Exception();
        return service.RoleByToken(token); }
        catch(Exception e) { return ""; }
    }

}
