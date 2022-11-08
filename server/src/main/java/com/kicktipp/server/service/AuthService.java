package com.kicktipp.server.service;

import com.kicktipp.server.model.Benutzer;
import com.kicktipp.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class AuthService {

    @Autowired
    UserRepository repo;

    public Benutzer getUserDetailsByToken(String token) { return repo.findByAuthtoken(token); }

    public String login(String email, String passwort) {
        Benutzer be = repo.findByEmailAndPasswort(email, passwort);
        if(be==null) return null;
        String token = email+passwort+LocalDateTime.now().toString();
        repo.updateAuth_token(token, be.getId());
        return token; }

    public Benutzer verifyToken(String token) { return repo.findByAuthtoken(token); }

}
