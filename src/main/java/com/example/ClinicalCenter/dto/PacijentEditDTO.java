package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Pacijent;

import java.util.Date;

public class PacijentEditDTO {
    private String imePacijenta;
    private String prezimePacijenta;
    private String email;
    private String adresa;
    private String grad;
    private String drzava;
    private String brojTelefona;
    private String username;
    private Date rodjen;
    private int jbo;

    public PacijentEditDTO(String imePacijenta, String prezimePacijenta, String email, String adresa, String grad, String drzava, String brojTelefona, String username,  Date rodjen) {
        this.imePacijenta = imePacijenta;
        this.prezimePacijenta = prezimePacijenta;
        this.email = email;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.brojTelefona = brojTelefona;
        this.username = username;
        this.rodjen = rodjen;
    }

    public PacijentEditDTO( Pacijent pacijent) {
        this.imePacijenta = pacijent.getImePacijenta();
        this.prezimePacijenta = pacijent.getPrezimePacijenta();
        this.email = pacijent.getEmail();
        this.adresa = pacijent.getAdresa();
        this.grad = pacijent.getGrad();
        this.drzava = pacijent.getDrzava();
        this.brojTelefona = pacijent.getBrojTelefona();
        this.username = pacijent.getUsername();
        this.rodjen = pacijent.getRodjen();
        this.jbo = pacijent.getJbo();
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getRodjen() {
        return rodjen;
    }

    public void setRodjen(Date rodjen) {
        this.rodjen = rodjen;
    }

    public int getJbo() {
        return jbo;
    }

    public void setJbo(int jbo) {
        this.jbo = jbo;
    }
}
