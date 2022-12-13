package com.kicktipp.server;

import com.kicktipp.server.model.Configuration;
import com.kicktipp.server.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.event.EventListener;

import java.io.ObjectInputFilter;
import java.time.LocalDate;

@SpringBootApplication
@ConfigurationPropertiesScan("com.kicktipp.server.applicationProperties")
public class ServerApplication {

    @Autowired
    ConfigRepository configRepository;

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void configErstellen() {
        Configuration config = new Configuration();
        config.setSysTime(LocalDate.now());
        //configRepository.save(config);
        System.out.println("works");
    }


}
