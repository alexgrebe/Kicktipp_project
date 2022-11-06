package com.kicktipp.server.model;

import javax.persistence.*;

@Entity
public class Profilbild {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Long ID;
    @Lob
    public byte[] data;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
