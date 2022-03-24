package dev.danvega.talks.notion.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDateTime;

public class Page {

    private String object;
    private String id;
    @JsonProperty("created_time")
    private LocalDateTime createdTime;
    @JsonProperty("last_edited_time")
    private LocalDateTime lastEditedTime;
    private String cover;
    private String icon;
    private boolean archived;
    private String url;
    private JsonNode properties;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getLastEditedTime() {
        return lastEditedTime;
    }

    public void setLastEditedTime(LocalDateTime lastEditedTime) {
        this.lastEditedTime = lastEditedTime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JsonNode getProperties() {
        return properties;
    }

    public void setProperties(JsonNode properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Page{" +
                "object='" + object + '\'' +
                ", id='" + id + '\'' +
                ", createdTime=" + createdTime +
                ", lastEditedTime=" + lastEditedTime +
                ", cover='" + cover + '\'' +
                ", icon='" + icon + '\'' +
                ", archived=" + archived +
                ", url='" + url + '\'' +
                ", properties=" + properties +
                '}';
    }
}
