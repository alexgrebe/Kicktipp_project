package com.kicktipp.server;

import com.kicktipp.server.model.Quoten;
import com.kicktipp.server.model.Spiel;
import com.kicktipp.server.model.Tipprunde;
import com.kicktipp.server.repository.MitgliedRepository;
import com.kicktipp.server.repository.SpielRepository;
import com.kicktipp.server.repository.TipprundeRepository;
import com.kicktipp.server.service.LigaService;
import com.kicktipp.server.service.TipprundeService;
import com.kicktipp.server.service.WetteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ServerApplicationTests {


    @Autowired
    TipprundeRepository repo;

    @Autowired
    SpielRepository spielRepository;

    @Autowired
    MitgliedRepository mitgliedRepository;

    @Autowired
    TipprundeService tipprundeService;

    @Autowired
    WetteService wetteService;

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

    @Test
    void benutzerIDByIdTest() {
        System.out.println(mitgliedRepository.findBenutzerIDById(2473L));
        System.out.println(mitgliedRepository.findBenutzerIDById(126L));
        System.out.println(mitgliedRepository.findBenutzerIDById(2465L));
        System.out.println(mitgliedRepository.findBenutzerIDById(3358L));
        System.out.println(mitgliedRepository.findBenutzerIDById(3387L));

        System.out.println(tipprundeService.getBenutzerIDByMitgliedID(2473L));
        System.out.println(tipprundeService.getBenutzerIDByMitgliedID(mitgliedRepository.findBenutzerIDById(3387L)));
    }

    @Test
    void checkQuote() {
        Iterable<Spiel> spiele = spielRepository.findAll();
        Quoten quote = wetteService.quoteBerechnen(spiele.iterator().next());
        assert(quote.getHeim()>=1);
        assert(quote.getAuswaerts()>=1);
        assert(quote.getUnentschieden()>=1);
    }

}
