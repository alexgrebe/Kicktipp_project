package com.kicktipp.server.service;

import com.kicktipp.server.model.Benutzer;
import com.kicktipp.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AuthService {

    @Autowired
    UserRepository repo;

    public Benutzer getUserDetailsByToken(String token) { return repo.findByAuthtoken(token); }

    public String login(String email, String passwort) { return ""; }

    public Benutzer verifyToken(String token) { return null; }
}
