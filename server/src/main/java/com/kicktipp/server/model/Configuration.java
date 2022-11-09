package com.kicktipp.server.model;

import javax.persistence.*;

@Entity
public class Configuration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(unique = true)
    public String attributeConfig;

    public String valueConfig;

    public String getAttribute() {
        return attributeConfig;
    }

    public void setAttribute(String attribute) {
        this.attributeConfig = attribute;
    }

    public String getValue() {
        return valueConfig;
    }

    public void setValue(String value) {
        this.valueConfig = value;
    }
}
