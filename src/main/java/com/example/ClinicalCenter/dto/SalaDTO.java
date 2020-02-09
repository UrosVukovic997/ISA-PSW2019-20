package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Sala;

public class SalaDTO {

    private long id;
    private String naziv;
    private int broj;

    public SalaDTO() {
    }

    public SalaDTO(Sala sala) {
        this(sala.getId(),sala.getNaziv(),sala.getBroj());
    }

    public SalaDTO(long id, String naziv, int broj) {
        this.id = id;
        this.naziv = naziv;
        this.broj = broj;
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

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }
}
