package dev.danvega.talks.controller;

import dev.danvega.talks.model.Talk;
import dev.danvega.talks.notion.model.Page;
import dev.danvega.talks.notion.NotionClient;
import dev.danvega.talks.notion.config.NotionConfigProperties;
import dev.danvega.talks.service.TalksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/talks")
public class TalkController {

    private final NotionClient client;
    private final NotionConfigProperties notionConfigProperties;

    public TalkController(NotionConfigProperties notionConfigProperties, NotionClient client) {
        this.notionConfigProperties = notionConfigProperties;
        this.client = client;
    }

    @GetMapping()
    public List<Talk> findAll() {
        List<Page> pages = client.databases.query(notionConfigProperties.databaseId());
        return pages.stream().map(TalksService::mapPageToTalk).toList();
    }

}
