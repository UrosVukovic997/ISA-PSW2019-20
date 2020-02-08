package com.example.ClinicalCenter.dto;

public class SearchLekarPacDTO {
    String ime;
    String prezime;
    Double ocena;
    String vreme;

    public SearchLekarPacDTO(String ime, String prezime, Double ocena, String vreme) {
        this.ime = ime;
        this.prezime = prezime;
        this.ocena = ocena;
        this.vreme = vreme;
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

    public Double getOcena() {
        return ocena;
    }

    public void setOcena(Double ocena) {
        this.ocena = ocena;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }
}
