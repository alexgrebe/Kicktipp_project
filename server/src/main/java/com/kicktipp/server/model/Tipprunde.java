package com.kicktipp.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipprunde {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Long ligaID;
    public String name;
    public Long besitzerID;
    public int ergebnisgewicht;
    public int tordiffgewicht;
    public int siegergewicht;
    public String passwort;
    public boolean privat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLigaID() {
        return ligaID;
    }

    public void setLigaID(Long ligaID) {
        this.ligaID = ligaID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBesitzerID() {
        return besitzerID;
    }

    public void setBesitzerID(Long besitzerID) {
        this.besitzerID = besitzerID;
    }

    public int getErgebnisgewicht() {
        return ergebnisgewicht;
    }

    public void setErgebnisgewicht(int ergebnisgewicht) {
        this.ergebnisgewicht = ergebnisgewicht;
    }

    public int getTordiffgewicht() {
        return tordiffgewicht;
    }

    public void setTordiffgewicht(int tordiffgewicht) {
        this.tordiffgewicht = tordiffgewicht;
    }

    public int getSiegergewicht() {
        return siegergewicht;
    }

    public void setSiegergewicht(int siegergewicht) {
        this.siegergewicht = siegergewicht;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public boolean isPrivat() {
        return privat;
    }

    public void setPrivat(boolean privat) {
        this.privat = privat;
    }
}
