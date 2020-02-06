package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Lekar;

import java.util.Date;

public class PacijentZakaziDTO {
    private String imePacijenta;
    private String prezimePacijenta;
    private String email;
    private String adresa;
    private String grad;
    private String drzava;
    private String brojTelefona;
    private String username;
    private String rodjen;
    private int jbo;
    private Lekar lekar;
    private Date pocetak;
    private Date kraj;
    private String emailLekara;

    public PacijentZakaziDTO(String imePacijenta, String prezimePacijenta, String email, String adresa, String grad, String drzava, String brojTelefona, String username, String rodjen, int jbo, Lekar lekar, Date pocetak, Date kraj, String emailLekara) {
        this.imePacijenta = imePacijenta;
        this.prezimePacijenta = prezimePacijenta;
        this.email = email;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.brojTelefona = brojTelefona;
        this.username = username;
        this.rodjen = rodjen;
        this.jbo = jbo;
        this.lekar = lekar;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.emailLekara = emailLekara;
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

    public String getRodjen() {
        return rodjen;
    }

    public void setRodjen(String rodjen) {
        this.rodjen = rodjen;
    }

    public int getJbo() {
        return jbo;
    }

    public void setJbo(int jbo) {
        this.jbo = jbo;
    }

    public Lekar getLekar() {
        return lekar;
    }

    public void setLekar(Lekar lekar) {
        this.lekar = lekar;
    }

    public Date getPocetak() {
        return pocetak;
    }

    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    public Date getKraj() {
        return kraj;
    }

    public void setKraj(Date kraj) {
        this.kraj = kraj;
    }

    public String getEmailLekara() {
        return emailLekara;
    }

    public void setEmailLekara(String emailLekara) {
        this.emailLekara = emailLekara;
    }
}
