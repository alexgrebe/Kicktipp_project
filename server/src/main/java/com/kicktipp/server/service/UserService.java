package com.kicktipp.server.service;

import com.kicktipp.server.model.Benutzer;
import com.kicktipp.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public Iterable<Benutzer> getById(Long id) {
        return repo.findAll();
    }

    public Benutzer addUser(Benutzer benutzer) {
        return repo.save(benutzer);
    }

    public Iterable<Benutzer> getAllUsers() {
        return repo.findAll();
    }
}
