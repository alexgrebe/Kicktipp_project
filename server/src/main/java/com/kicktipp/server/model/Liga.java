package com.kicktipp.server.model;

import javax.persistence.*;

@Entity
public class Liga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String name;

    @Lob
    public String logoID;

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

    public String getLogoID() {
        return logoID;
    }

    public void setLogoID(String logoID) {
        this.logoID = logoID;
    }

}
