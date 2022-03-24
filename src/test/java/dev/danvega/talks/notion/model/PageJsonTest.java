package dev.danvega.talks.notion.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
public class PageJsonTest {

    @Autowired
    private JacksonTester<Page> json;

    @Value("classpath:page.json")
    private Resource pageJSON;

    @Test
    void testPageDeserialization() throws IOException {
        Page page = json.read(pageJSON).getObject();
        assertEquals("page", page.getObject());
        assertEquals("9323917e-905e-43b5-ac06-6f15c66f9a29", page.getId());
        assertEquals(LocalDateTime.of(2022,02,17,11,49),page.getCreatedTime());
        assertEquals(LocalDateTime.of(2022,02,26,18,25),page.getLastEditedTime());
        assertNull(page.getCover());
        assertNull(page.getIcon());
        // database rows (page.getProperties()
        assertEquals("Tanzu TV - Code",page.getProperties().get("Title").get("title").get(0).get("text").get("content").asText());
        assertEquals(LocalDateTime.of(2022,02,23,15,00),LocalDateTime.parse(page.getProperties().get("StartDate").get("date").get("start").asText(), DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        assertEquals(LocalDateTime.of(2022,02,23,17,00),LocalDateTime.parse(page.getProperties().get("EndDate").get("date").get("start").asText(), DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        assertEquals("https://tanzu.vmware.com/developer/tv/code/0062/", page.getProperties().get("URL").get("url").asText());
        assertEquals("https://www.twitch.tv/videos/1307820816", page.getProperties().get("Recording").get("url").asText());
    }
}
