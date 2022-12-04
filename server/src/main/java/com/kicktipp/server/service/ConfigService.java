package com.kicktipp.server.service;

import com.kicktipp.server.model.Configuration;
import com.kicktipp.server.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ConfigService {
    @Autowired
    ConfigRepository repo;

    public void updateSysTime(LocalDate date) {
        repo.updateSysTime(repo.findAll().iterator().next().getId(), date);
    }

}
