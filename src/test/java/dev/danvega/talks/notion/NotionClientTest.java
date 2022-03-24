package dev.danvega.talks.notion;

import dev.danvega.talks.notion.config.NotionConfigProperties;
import dev.danvega.talks.notion.model.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NotionClientTest {

    @Autowired
    private NotionClient client;

    @Autowired
    private NotionConfigProperties config;

    @Test
    void contextLoads() {
        assertNotNull(client);
        assertNotNull(client.databases);
    }

    @Test
    void testDatabaseQueryCall() {
        List<Page> pages = client.databases.query(config.databaseId());
        assertTrue(pages.size() > 0);
    }

}