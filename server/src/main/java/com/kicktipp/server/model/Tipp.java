package com.kicktipp.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Long spielID;
    public Long mitgliedID;
    public int toreHeim;
    public int toreAus;

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

    public Long getMitgliedID() {
        return mitgliedID;
    }

    public void setMitgliedID(Long mitgliedID) {
        this.mitgliedID = mitgliedID;
    }

    public int getToreHeim() {
        return toreHeim;
    }

    public void setToreHeim(int toreHeim) {
        this.toreHeim = toreHeim;
    }

    public int getToreAus() {
        return toreAus;
    }

    public void setToreAus(int toreAus) {
        this.toreAus = toreAus;
    }
}
