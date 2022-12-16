package com.kicktipp.server.service;

import com.kicktipp.server.model.Tipprunde;
import com.kicktipp.server.repository.TipprundeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TipprundenServiceTest {

    @Autowired
    TipprundeService tipprundeService;

    @Autowired
    TipprundeRepository tipprundeRepository;

    @Test
    public void tipprundeErstellenTest() {
        Tipprunde testRunde = new Tipprunde();
        testRunde.setBesitzerID(1L);
        testRunde.setPasswort("1234");
        testRunde.setName("Testrunde");
        testRunde.setErgebnisgewicht(1);
        testRunde.setSiegergewicht(1);
        testRunde.setTordiffgewicht(1);
        testRunde.setLigaID(1234L);
        tipprundeService.createTipprunde(testRunde);
        List<Tipprunde> liste = tipprundeService.getEigeneTipprunden(1L);
        for(Tipprunde item : liste) {
            if(item.getBesitzerID().equals(1L) && item.getName().equals("Testrunde")) {
                assert(testRunde.getPasswort().equals(item.getPasswort()) && testRunde.getName().equals(item.getName()) &&
                        testRunde.getLigaID().equals(item.getLigaID()));
                tipprundeRepository.deleteById(item.getId());
                break;
            }
        }

    }
}
