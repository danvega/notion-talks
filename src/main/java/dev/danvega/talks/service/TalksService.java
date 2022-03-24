package dev.danvega.talks.service;

import dev.danvega.talks.model.Talk;
import dev.danvega.talks.notion.model.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TalksService {

    public static Talk mapPageToTalk(Page page) {
        return new Talk(
                page.getId(),
                page.getProperties().get("Title").get("title").get(0).get("text").get("content").asText(),
                LocalDateTime.parse(page.getProperties().get("StartDate").get("date").get("start").asText(), DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                LocalDateTime.parse(page.getProperties().get("EndDate").get("date").get("start").asText(), DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                page.getProperties().get("URL").get("url").asText(),
                page.getProperties().get("Recording").get("url").asText());
    }

}
