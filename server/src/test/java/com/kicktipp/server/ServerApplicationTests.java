package com.kicktipp.server;

import com.kicktipp.server.model.Liga;
import com.kicktipp.server.model.Spiel;
import com.kicktipp.server.service.LigaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerApplicationTests {


	@Autowired
	LigaService service;
	@Test
	void contextLoads() {
		Liga liga = new Liga();
		liga.setName("jsjssj");
		service.addLeague(liga);
		Spiel spiel = new Spiel();
		spiel.heimteam = "jhsdh";
		spiel.setLiga(liga);
		service.addGame(spiel);
		System.out.println(service.getAllLeagues().iterator().next().getSpieleList().get(0).heimteam);
		assert service.getAllLeagues().iterator().next().getSpieleList().get(0).heimteam.equals("jhsdh");
	}

}
