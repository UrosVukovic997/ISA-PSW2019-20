package com.example.ClinicalCenter.model;

import com.example.ClinicalCenter.dto.AdminKcDTO;

import javax.persistence.*;

@Entity
public class AdminKC {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ime", nullable = false)
    private String ime;

    @Column(name = "prezime", nullable = false)
    private String prezime;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "lozinka", nullable = false)
    private String lozinka;

    @Column(name = "prvoPrijavljivanje", nullable = false)
    private Boolean prvoPrijavljivanje = true;

    public AdminKC() {
    }

    public AdminKC(String ime, String prezime, String email, String username, String lozinka, Boolean prvoPrijavljivanje) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.username = username;
        this.lozinka = lozinka;
        this.prvoPrijavljivanje = prvoPrijavljivanje;
    }

    public AdminKC(AdminKcDTO admin) {
        this.ime = admin.getIme();
        this.prezime = admin.getPrezime();
        this.email = admin.getEmail();
        this.username = admin.getUsername();
        this.lozinka = admin.getLozinka();
        this.prvoPrijavljivanje = admin.getPrvoPrijavljivanje();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Boolean getPrvoPrijavljivanje() {
        return prvoPrijavljivanje;
    }

    public void setPrvoPrijavljivanje(Boolean prvoPrijavljivanje) {
        this.prvoPrijavljivanje = prvoPrijavljivanje;
    }
}
