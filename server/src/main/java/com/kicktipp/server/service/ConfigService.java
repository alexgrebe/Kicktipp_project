package com.kicktipp.server.service;

import com.kicktipp.server.model.Configuration;
import com.kicktipp.server.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {
    @Autowired
    ConfigRepository repo;

    public Iterable<Configuration> getAllAttributes() {
        return repo.findAll();
    }

    public Configuration addAttribute(Configuration configuration) {
        return repo.save(configuration);
    }

    public void updateValueByAttribute(String attribute, String value) {
        repo.updateConfig_Value(attribute,value);
    }

}
