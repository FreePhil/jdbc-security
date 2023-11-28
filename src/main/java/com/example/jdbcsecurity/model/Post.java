package com.example.jdbcsecurity.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Post {


    @Id private Integer id;
    private String title;
    private String content;
    private LocalDateTime pubblishedOn;
    private LocalDateTime updatedOn;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;

        this.pubblishedOn = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPubblishedOn() {
        return pubblishedOn;
    }

    public void setPubblishedOn(LocalDateTime pubblishedOn) {
        this.pubblishedOn = pubblishedOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", pubblishedOn=" + pubblishedOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
