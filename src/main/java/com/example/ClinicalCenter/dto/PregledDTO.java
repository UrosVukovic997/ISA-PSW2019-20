package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Pregled;
import com.example.ClinicalCenter.model.Termin;

public class PregledDTO {

    private long id;
    private String ime_pacijenta;
    private String prezime_pacijenta;
    private String email;
    private String jbo;
    private Termin termin;

    public PregledDTO() {
    }

    public PregledDTO(Pregled pregled) {
        this(pregled.getId(),pregled.getIme_pacijenta(),pregled.getPrezime_pacijenta(),pregled.getEmail(),pregled.getJbo(),pregled.getTermin());
    }

    public PregledDTO(long id, String ime_pacijenta, String prezime_pacijenta, String email, String jbo, Termin termin) {
        this.id = id;
        this.ime_pacijenta = ime_pacijenta;
        this.prezime_pacijenta = prezime_pacijenta;
        this.email = email;
        this.jbo = jbo;
        this.termin = termin;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
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
