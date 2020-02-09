package com.example.ClinicalCenter.dto;

import java.util.Date;

public class PregledPacDTO {
    Date pocetak;
    Date kraj;
    String ime;
    String prezime;

    public PregledPacDTO(Date pocetak, Date kraj, String ime, String prezime) {
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.ime = ime;
        this.prezime = prezime;
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
}
