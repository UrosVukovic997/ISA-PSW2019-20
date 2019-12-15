package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Klinika;

public class KlinikaDTO {

    private Long id;
    private String nazivKlinike;
    private String grad;
    private double ocena;

    public KlinikaDTO() {
    }

    public KlinikaDTO(Long id, String nazivKlinike, String grad, float ocena) {
        this.id = id;
        this.nazivKlinike = nazivKlinike;
        this.grad = grad;
        this.ocena = ocena;
    }

    public KlinikaDTO(Klinika klinika) {
        this.id = klinika.getId();
        this.nazivKlinike = klinika.getNazivKlinike();
        this.grad = klinika.getGrad();
        this.ocena = klinika.getOcena();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivKlinike() {
        return nazivKlinike;
    }

    public void setNazivKlinike(String nazivKlinike) {
        this.nazivKlinike = nazivKlinike;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }
}
