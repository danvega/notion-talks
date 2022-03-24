package dev.danvega.talks.notion.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.core.io.Resource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
public class DatabaseJsonTest {

    @Autowired
    private JacksonTester<Database> json;

    @Value("classpath:talks.json")
    private Resource talksJSON;

    @Test
    void testDeserialize() throws IOException {
        Database notionDB = json.read(talksJSON).getObject();
        assertEquals("list",notionDB.getObject());
        assertEquals(10,notionDB.getPages().size());
        assertNull(notionDB.getNextCursor());
        assertFalse(notionDB.getHasMore());
    }


}
