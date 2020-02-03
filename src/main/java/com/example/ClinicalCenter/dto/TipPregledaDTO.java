package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.TipPregleda;

public class TipPregledaDTO {

    private long id;
    private String naziv;
    private boolean obrisi;
    private Double cena;

    public TipPregledaDTO() {
    }

    public TipPregledaDTO(TipPregleda tipPregleda) {
        this(tipPregleda.getId(),tipPregleda.getNaziv(),tipPregleda.isObrisan(),tipPregleda.getCena());
    }

    public TipPregledaDTO(long id, String naziv, boolean obrisi, Double cena) {
        this.id = id;
        this.naziv = naziv;
        this.obrisi = obrisi;
        this.cena = cena;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public boolean isObrisi() {
        return obrisi;
    }

    public void setObrisi(boolean obrisi) {
        this.obrisi = obrisi;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }
}
