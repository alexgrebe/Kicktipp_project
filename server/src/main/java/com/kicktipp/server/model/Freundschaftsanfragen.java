package com.kicktipp.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Freundschaftsanfragen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Long empfanger;
    public Long sender;
    public boolean bestatigt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpfanger() {
        return empfanger;
    }

    public void setEmpfanger(Long empfanger) {
        this.empfanger = empfanger;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public boolean isBestatigt() {
        return bestatigt;
    }

    public void setBestatigt(boolean bestatigt) {
        this.bestatigt = bestatigt;
    }
}
