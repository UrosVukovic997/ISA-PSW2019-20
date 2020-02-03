package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Pacijent;

import java.util.Date;

public class PacijentDTO {

    private Long id;
    private String imePacijenta;
    private String prezimePacijenta;
    private String email;
    private String password;
    private String adresa;
    private String grad;
    private String drzava;
    private String brojTelefona;
    private int jbo;
    private String username;
    private Boolean odobren = false;
    private Boolean potvrdio = false;
    private Date rodjen;

    public PacijentDTO() {

    }

    public PacijentDTO(Pacijent pacijent) {
        this(pacijent.getId(), pacijent.getImePacijenta(), pacijent.getPrezimePacijenta(), pacijent.getEmail(), pacijent.getPassword(), pacijent.getAdresa(), pacijent.getGrad(), pacijent.getGrad(), pacijent.getBrojTelefona(), pacijent.getJbo(), pacijent.getPotvrdio(), pacijent.getOdobren(), pacijent.getUsername(), pacijent.getRodjen() );
    }

    public PacijentDTO(Long id, String imePacijenta, String prezimePacijenta, String email, String lozinka, String adresa, String grad, String drzava, String brojTelefona, int jbo, Boolean potvrdio, Boolean odobrio, String username, Date rodjen) {
        this.id = id;
        this.imePacijenta = imePacijenta;
        this.prezimePacijenta = prezimePacijenta;
        this.email = email;
        this.password = lozinka;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.brojTelefona = brojTelefona;
        this.jbo = jbo;
        this.potvrdio = potvrdio;
        this.odobren = odobrio;
        this.username = username;
        this.rodjen = rodjen;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getRodjen() { return rodjen; }

    public void setRodjen(Date rodjen) { this.rodjen = rodjen; }
}
