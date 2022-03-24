package dev.danvega.talks.notion.service;

import dev.danvega.talks.notion.config.NotionConfigProperties;
import dev.danvega.talks.notion.model.Database;
import dev.danvega.talks.notion.model.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DatabaseService {

    private final RestTemplate restTemplate;
    private final NotionConfigProperties notionConfigProps;
    private final Logger log = LoggerFactory.getLogger(DatabaseService.class);

    public DatabaseService(RestTemplate restTemplate, NotionConfigProperties notionConfigProps) {
        this.restTemplate = restTemplate;
        this.notionConfigProps = notionConfigProps;
    }

    public List<Page> query(String databaseId) {
        String url = notionConfigProps.apiUrl() + "/v1/databases/" + databaseId + "/query";
        log.info("Querying Notion database: {}", url);
        ResponseEntity<Database> db = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(getDefaultHeaders()),
                Database.class);

        return db.getBody().getPages();
    }

    private HttpHeaders getDefaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Notion-Version", notionConfigProps.apiVersion());
        headers.set("Authorization",notionConfigProps.authToken());
        return headers;
    }
}
