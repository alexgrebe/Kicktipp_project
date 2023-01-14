package com.kicktipp.server.model;

import javax.persistence.*;

@Entity
public class Wette {

    public enum Auswahl {
        HEIM, AUSWAERTS, UNENTSCHIEDEN
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Long id;
    public Long spielID;
    public Long benutzerID;
    public int einsatz;
    public double quote;
    @Enumerated(EnumType.STRING)
    public Auswahl auswahl;

    public Auswahl getAuswahl() {
        return auswahl;
    }

    public void setAuswahl(Auswahl auswahl) {
        this.auswahl = auswahl;
    }

    public double getQuote() {
        return quote;
    }

    public void setQuote(double quote) {
        this.quote = quote;
    }
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

}
