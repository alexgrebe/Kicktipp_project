package com.kicktipp.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Wette {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Long id;
    public Long spielID;
    public Long benutzerID;
    public int einsatz;
    public LocalDate datum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpielID() {
        return spielID;
    }

    public void setSpielID(Long spielID) {
        this.spielID = spielID;
    }

    public Long getBenutzerID() {
        return benutzerID;
    }

    public void setBenutzerID(Long benutzerID) {
        this.benutzerID = benutzerID;
    }

    public int getEinsatz() {
        return einsatz;
    }

    public void setEinsatz(int einsatz) {
        this.einsatz = einsatz;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
