package com.kicktipp.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Spiel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Integer Spieltag;

    public Date datum;

    public Integer heimtore;

    public Integer auswaertstore;

    public String heimteam;

    public String auswaertsteam;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "liga")
    public Liga liga;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeimteam() {
        return heimteam;
    }

    public void setHeimteam(String heimteam) {
        this.heimteam = heimteam;
    }

    public String getAuswaertsteam() {
        return auswaertsteam;
    }

    public void setAuswaertsteam(String auswaertsteam) {
        this.auswaertsteam = auswaertsteam;
    }

    public Integer getSpieltag() {
        return Spieltag;
    }

    public void setSpieltag(Integer spieltag) {
        Spieltag = spieltag;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Integer getHeimtore() {
        return heimtore;
    }

    public void setHeimtore(Integer heimtore) {
        this.heimtore = heimtore;
    }

    public Integer getAuswaertstore() {
        return auswaertstore;
    }

    public void setAuswaertstore(Integer auswaertstore) {
        this.auswaertstore = auswaertstore;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

}
