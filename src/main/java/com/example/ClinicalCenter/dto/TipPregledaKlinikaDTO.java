package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.TipPregleda;

public class TipPregledaKlinikaDTO {
    private String naziv;
    private Double cena;

    public TipPregledaKlinikaDTO(String naziv, Double cena) {

        this.naziv = naziv;
        this.cena = cena;
    }

    public TipPregledaKlinikaDTO(TipPregleda tipP) {
        this.naziv = tipP.getNaziv();
        this.cena = tipP.getCena();
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }
}
