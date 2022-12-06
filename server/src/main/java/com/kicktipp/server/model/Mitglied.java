package com.kicktipp.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mitglied {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;
    public Long tipprundeID;
    public Long benutzerID;
    public int punkte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTipprundeID() {
        return tipprundeID;
    }

    public void setTipprundeID(Long tipprundeID) {
        this.tipprundeID = tipprundeID;
    }

    public Long getBenutzerID() {
        return benutzerID;
    }

    public void setBenutzerID(Long benutzerID) {
        this.benutzerID = benutzerID;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }
}
