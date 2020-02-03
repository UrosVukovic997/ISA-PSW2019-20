package com.example.ClinicalCenter.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Pregled {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jbo", nullable = false)
    private String jbo;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "firstName", nullable = false)
    private String ime_pacijenta;

    @Column(name = "lastName", nullable = false)
    private String prezime_pacijenta;

    @Column(name = "town", nullable = false)
    private String grad;

    @Column(name = "nationality", nullable = false)
    private String drzavljanstvo;

    @Column(name = "emergency", nullable = false)
    private String hitnost;

    @Column(name = "type", nullable = false)
    private String tip;

    @OneToOne
    private Termin termin;

    @OneToOne
    private TipPregleda tipPregleda;

    @OneToOne
    private Lekar lekar;

    @OneToOne
    private Pacijent pacijent;

    public Pregled() {
    }

    public Pregled(Long id, String ime_pacijenta, String prezime_pacijenta, String email, String jbo) {
        this.id = id;
        this.ime_pacijenta = ime_pacijenta;
        this.prezime_pacijenta = prezime_pacijenta;
        this.email = email;
        this.jbo = jbo;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme_pacijenta() {
        return ime_pacijenta;
    }

    public void setIme_pacijenta(String ime_pacijenta) {
        this.ime_pacijenta = ime_pacijenta;
    }

    public String getPrezime_pacijenta() {
        return prezime_pacijenta;
    }

    public void setPrezime_pacijenta(String prezime_pacijenta) {
        this.prezime_pacijenta = prezime_pacijenta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJbo() {
        return jbo;
    }

    public void setJbo(String jbo) {
        this.jbo = jbo;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }
}
