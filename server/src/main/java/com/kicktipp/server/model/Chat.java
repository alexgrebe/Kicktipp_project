package com.kicktipp.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public Long party1Id;
    public Long party2Id;
    public Long tipprundeID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setParty1Id(Long party1Id) {
        this.party1Id = party1Id;
    }

    public void setParty2Id(Long party2Id) {
        this.party2Id = party2Id;
    }

    public void setTipprundeID(Long tipprundeID) {
        this.tipprundeID = tipprundeID;
    }

    public Long getParty1Id() {
        return party1Id;
    }

    public Long getParty2Id() {
        return party2Id;
    }

    public Long getTipprundeID() {
        return tipprundeID;
    }




}
