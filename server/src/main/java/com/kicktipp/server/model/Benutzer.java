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
    public int geld;
    public boolean wetterlaubnis;
    @Column(unique = true)
    public String email;
    @Lob
    public String profilepicturedata;

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

    public String getProfilepicturedata() {
        return profilepicturedata;
    }

    public void setProfilepicturedata(String profilbildId) {
        this.profilepicturedata = profilbildId;
    }

    public int getGeld() {
        return geld;
    }

    public void setGeld(int geld) {
        this.geld = geld;
    }

    public boolean isWetterlaubnis() {
        return wetterlaubnis;
    }

    public void setWetterlaubnis(boolean wetterlaubnis) {
        this.wetterlaubnis = wetterlaubnis;
    }
}
