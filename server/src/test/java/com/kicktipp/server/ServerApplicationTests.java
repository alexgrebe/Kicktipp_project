package com.kicktipp.server;

import com.kicktipp.server.model.Tipprunde;
import com.kicktipp.server.repository.TipprundeRepository;
import com.kicktipp.server.service.LigaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ServerApplicationTests {


    @Autowired
    TipprundeRepository repo;

    @Test
    void contextLoads() {
    }

    //Daten in der Datenbank: freund -> sender = 308, empfanger = 1
    //                          Tipprunde 1 -> name = Bundesliga Tipprunde, privat = false, besitzerID = 1
    //                          Tipprunde 2 -> name = Bundesliga Tipprunde Privat, privat = true, besitzerID = 1
    @Test
    void tipprundenRepositoryFindTipprundeTest() {
        List<Tipprunde> tipprunden = repo.findTipprunde(308L);
        for(Tipprunde tipprunde : tipprunden) {
            System.out.println(tipprunde.getName());
        }
    }
}
