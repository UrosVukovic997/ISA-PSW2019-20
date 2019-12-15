package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Administrator;

public class AdministratorDTO {

    private Long id;
    private String ime;
    private String prezime;
    private String email;
    private String username;
    private String lozinka;
    private String klinika;

    public AdministratorDTO() {
    }

    public AdministratorDTO(Long id, String ime, String prezime, String email, String username, String lozinka, String klinika) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.username = username;
        this.lozinka = lozinka;
        this.klinika = klinika;
    }

    public AdministratorDTO(Administrator administrator) {
        this.id = administrator.getId();
        this.ime = administrator.getIme();
        this.prezime = administrator.getPrezime();
        this.email = administrator.getEmail();
        this.username = administrator.getUsername();
        this.lozinka = administrator.getLozinka();
        this.klinika = administrator.getKlinika();
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

    public String getKlinika() {
        return klinika;
    }

    public void setKlinika(String klinika) {
        this.klinika = klinika;
    }
}
