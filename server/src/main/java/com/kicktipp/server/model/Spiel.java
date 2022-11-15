package com.kicktipp.server.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Spiel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Integer spieltag;

    public LocalDate datum;

    public Integer heimtore;

    public Integer auswaertstore;

    public String heimteam;

    public String auswaertsteam;

    public Long ligaFremdschlussel;

    public Long getLigaFremdschlussel() {
        return ligaFremdschlussel;
    }

    public void setLigaFremdschlussel(Long ligaFremdschlussel) {
        this.ligaFremdschlussel = ligaFremdschlussel;
    }

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
        return spieltag;
    }

    public void setSpieltag(Integer spieltag) {
        this.spieltag = spieltag;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
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

}
