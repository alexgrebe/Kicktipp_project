package com.kicktipp.server.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Quoten {

    @Id
    Long id;
    Long spielID;
    double heim;
    double unentschieden;
    double auswaerts;

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

    public double getHeim() {
        return heim;
    }

    public void setHeim(double heim) {
        this.heim = heim;
    }

    public double getUnentschieden() {
        return unentschieden;
    }

    public void setUnentschieden(double unentschieden) {
        this.unentschieden = unentschieden;
    }

    public double getAuswaerts() {
        return auswaerts;
    }

    public void setAuswaerts(double auswaerts) {
        this.auswaerts = auswaerts;
    }
}
