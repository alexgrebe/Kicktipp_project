package com.kicktipp.server.service;

import com.kicktipp.server.repository.WetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WetteService {

    @Autowired
    private WetteRepository wetteRepository;
}
