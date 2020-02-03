package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.AdminKC;

public class AdminKcDTO {

    private Long id;
    private String ime;
    private String prezime;
    private String email;
    private String username;
    private String lozinka;
    private Boolean prvoPrijavljivanje;

    public AdminKcDTO() {
    }

    public AdminKcDTO(Long id, String ime, String prezime, String email, String username,
                      String lozinka, Boolean prvoPrijavljivanje) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.username = username;
        this.lozinka = lozinka;
        this.prvoPrijavljivanje = prvoPrijavljivanje;
    }

    public AdminKcDTO(AdminKC admin){
        this.id = admin.getId();
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
