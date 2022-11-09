package com.kicktipp.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Liga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String name;

    public Long logoID;

    @OneToMany(mappedBy = "liga", fetch = FetchType.LAZY, orphanRemoval = false)
    public List<Spiel> spieleList = new ArrayList<>();

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

    public Long getLogoID() {
        return logoID;
    }

    public void setLogoID(Long logoID) {
        this.logoID = logoID;
    }

    public List<Spiel> getSpieleList() {
        return spieleList;
    }
}
