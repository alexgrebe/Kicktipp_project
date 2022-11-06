package com.kicktipp.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Benutzer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String vorname;
    public String nachname;
    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate geburtsdatum;
    public String passwort;
    public String authtoken;
    public String role;
    public String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profilbildId", referencedColumnName = "ID")
    public Profilbild profilbildId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String auth_token) {
        this.authtoken = auth_token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profilbild getProfilbildId() {
        return profilbildId;
    }

    public void setProfilbildId(Profilbild profilbildId) {
        this.profilbildId = profilbildId;
    }
}