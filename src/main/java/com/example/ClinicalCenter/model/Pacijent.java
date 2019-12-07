package com.example.ClinicalCenter.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pacijent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ime", nullable = false)
    private String imePacijenta;

    @Column(name = "prezime", nullable = false)
    private String prezimePacijenta;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "lozinka", nullable = false)
    private String lozinka;

    @Column(name = "adresaPrebivalista", nullable = false)
    private String adresa;

    @Column(name = "grad", nullable = false)
    private String grad;

    @Column(name = "drzava", nullable = false)
    private String drzava;

    @Column(name = "brojTelefona", nullable = false)
    private String brojTelefona;

    @Column(name = "jbo", nullable = false)
    private Integer jbo;

    @Column(name = "odobren", nullable = false)
    private Boolean odobren;

    @Column(name = "potvrdio", nullable = false)
    private Boolean potvrdio;


    public Pacijent() {
        imePacijenta = "";
        prezimePacijenta = "";
        email = "";
        lozinka = "";
        adresa = "";
        grad = "";
        drzava = "";
        brojTelefona = "";
        jbo = 0;
        odobren = false;
        potvrdio = false;
    }

    public Pacijent(Long id, String imePacijenta, String prezimePacijenta, String email, String lozinka, String adresa, String grad, String drzava, String brojTelefona, Integer jbo, Boolean odobren, Boolean potvrdio) {
        this.id = id;
        this.imePacijenta = imePacijenta;
        this.prezimePacijenta = prezimePacijenta;
        this.email = email;
        this.lozinka = lozinka;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.brojTelefona = brojTelefona;
        this.jbo = jbo;
        this.odobren = odobren;
        this.potvrdio = potvrdio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImePacijenta() {
        return imePacijenta;
    }

    public void setImePacijenta(String imePacijenta) {
        this.imePacijenta = imePacijenta;
    }

    public String getPrezimePacijenta() {
        return prezimePacijenta;
    }

    public void setPrezimePacijenta(String prezimePacijenta) {
        this.prezimePacijenta = prezimePacijenta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public Integer getJbo() {
        return jbo;
    }

    public void setJbo(Integer jbo) {
        this.jbo = jbo;
    }

    public Boolean getOdobren() {
        return odobren;
    }

    public void setOdobren(Boolean odobren) {
        odobren = odobren;
    }
}
