package dev.danvega.talks.controller;

import dev.danvega.talks.notion.NotionClient;
import dev.danvega.talks.notion.config.NotionConfigProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@WebMvcTest(TalkController.class)
class TalkControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private NotionConfigProperties config;

    @MockBean
    private NotionClient client;

    @Test
    void contextLoads() {
        assertNotNull(mvc);
        assertNotNull(config);
        assertNotNull(client);
    }

}