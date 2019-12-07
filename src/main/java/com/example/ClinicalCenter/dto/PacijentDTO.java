package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Pacijent;

public class PacijentDTO {

    private Long id;
    private String imePacijenta;
    private String prezimePacijenta;
    private String email;
    private String lozinka;
    private String adresa;
    private String grad;
    private String drzava;
    private String brojTelefona;
    private int jbo;
    private Boolean odobren = false;
    private Boolean potvrdio = false;

    public PacijentDTO() {

    }

    public PacijentDTO(Pacijent pacijent) {
        this(pacijent.getId(), pacijent.getImePacijenta(), pacijent.getPrezimePacijenta(), pacijent.getEmail(), pacijent.getLozinka(), pacijent.getAdresa(), pacijent.getGrad(), pacijent.getGrad(), pacijent.getBrojTelefona(), pacijent.getJbo(), pacijent.getPotvrdio(), pacijent.getOdobren() );
    }

    public PacijentDTO(Long id, String imePacijenta, String prezimePacijenta, String email, String lozinka, String adresa, String grad, String drzava, String brojTelefona, int jbo, Boolean potvrdio, Boolean odobrio) {
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
        this.potvrdio = potvrdio;
        this.odobren = odobrio;
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

    public int getJbo() {
        return jbo;
    }

    public void setJbo(int jbo) {
        this.jbo = jbo;
    }

    public Boolean getOdobren() {
        return odobren;
    }

    public void setOdobren(Boolean odobren) {
        this.odobren = odobren;
    }

    public Boolean getPotvrdio() {
        return potvrdio;
    }

    public void setPotvrdio(Boolean potvrdio) {
        this.potvrdio = potvrdio;
    }
}
