package com.kicktipp.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wetterlaubnis {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Long id;
    public Long benutzerID;
    public boolean entscheidung;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBenutzerID() {
        return benutzerID;
    }

    public void setBenutzerID(Long benutzerID) {
        this.benutzerID = benutzerID;
    }

    public boolean isEntscheidung() {
        return entscheidung;
    }

    public void setEntscheidung(boolean entscheidung) {
        this.entscheidung = entscheidung;
    }
}
