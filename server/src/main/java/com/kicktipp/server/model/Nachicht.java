package com.kicktipp.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nachicht {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Long chatId;

    public Long time;
    public Long benutzerID;
    public String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Long getId() {
        return id;
    }

    public long getTime() {
        return time;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setBenutzerID(Long benutzerID) {
        this.benutzerID = benutzerID;
    }

    public Long getBenutzerID() {
        return benutzerID;
    }
    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }
}
