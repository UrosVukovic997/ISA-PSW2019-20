package com.example.ClinicalCenter.model;

import com.example.ClinicalCenter.dto.AdministratorDTO;

import javax.persistence.*;

@Entity
public class Administrator {

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

    @Column(name = "klinika", nullable = false)
    private String klinika;

    public Administrator() {
    }

    public Administrator(String ime, String prezime, String email, String username, String lozinka, String klinika) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.username = username;
        this.lozinka = lozinka;
        this.klinika = klinika;
    }

    public Administrator(AdministratorDTO administratorDTO) {
        this.ime = administratorDTO.getIme();
        this.prezime = administratorDTO.getPrezime();
        this.email = administratorDTO.getEmail();
        this.username = administratorDTO.getUsername();
        this.lozinka = administratorDTO.getLozinka();
        this.klinika = administratorDTO.getKlinika();
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
