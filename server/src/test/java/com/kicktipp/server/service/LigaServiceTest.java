package com.kicktipp.server.service;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LigaServiceTest {
    @Autowired
    LigaService service;

    @Test
    public void testReadCSV() throws IOException, CsvException {
        Path path = Paths.get("src/test/resources/deutschland-master/2020s/2020-21/de.1.csv").toAbsolutePath();
        service.readCSV(Files.newBufferedReader(path), 1L);
    }
}
