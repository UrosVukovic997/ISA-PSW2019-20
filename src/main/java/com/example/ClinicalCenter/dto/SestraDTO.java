package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Sestra;

public class SestraDTO {

    private Long id;
    private String ime;
    private String prezime;
    private String email;
    private String adresa;
    private String username;
    private String klinika;

    public SestraDTO() {
    }

    public SestraDTO(Long id, String ime, String prezime, String email, String adresa, String username, String klinika) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.adresa = adresa;
        this.username = username;
        this.klinika = klinika;
    }
    public SestraDTO(Sestra s) {
        this.id = s.getId();
        this.ime = s.getIme();
        this.prezime = s.getPrezime();
        this.email = s.getEmail();
        this.adresa = s.getAdresa();
        this.username = s.getUsername();
        this.klinika = s.getKlinika();
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

    public String getKlinika() {
        return klinika;
    }

    public void setKlinika(String klinika) {
        this.klinika = klinika;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
