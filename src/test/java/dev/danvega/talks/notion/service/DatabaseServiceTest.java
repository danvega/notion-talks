package dev.danvega.talks.notion.service;

import dev.danvega.talks.notion.model.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DatabaseServiceTest {

    @Autowired
    private DatabaseService service;

    @Test
    void testQueryWithValidDatabaseId() {
        List<Page> pages = service.query("7833c2e7be20451dbabd6abbc6eddabd");
        assertTrue(pages.size() > 0);
    }

    @Test
    void testQueryWithInvalidDatabaseId() {
        HttpClientErrorException exception = assertThrows(HttpClientErrorException.class, () -> {
            service.query(UUID.randomUUID().toString());
        });
        assertEquals(HttpStatus.NOT_FOUND,exception.getStatusCode());
    }
}