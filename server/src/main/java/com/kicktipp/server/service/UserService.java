package com.kicktipp.server.service;

import com.kicktipp.server.model.User;
import com.kicktipp.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {

    @Autowired
    UserRepository repo;

    public Iterable<User> getById(Long id) {
        return repo.findAll();
    }
}
