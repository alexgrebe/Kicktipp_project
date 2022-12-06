package com.kicktipp.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Configuration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate sysTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSysTime() {
        return sysTime;
    }

    public void setSysTime(LocalDate sysTime) {
        this.sysTime = sysTime;
    }
}
