package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Klinika;
import com.example.ClinicalCenter.model.TipPregleda;

import java.util.ArrayList;
import java.util.List;

public class KlinikaTipDTO {
    private Long id;
    private String nazivKlinike;
    private String grad;
    private double ocena;
    List<TipPregledaDTO> tpkDTOs;

    public KlinikaTipDTO(Long id, String nazivKlinike, String grad, double ocena, List<TipPregledaDTO> tpkDTOs) {
        this.id = id;
        this.nazivKlinike = nazivKlinike;
        this.grad = grad;
        this.ocena = ocena;
        this.tpkDTOs = tpkDTOs;
    }

    public KlinikaTipDTO(List<TipPregledaDTO> tipP, Klinika k) {
        this.id = k.getId();
        this.nazivKlinike = k.getNazivKlinike();
        this.grad = k.getGrad();
        this.ocena = k.getOcena();
        this.tpkDTOs = tipP;
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

    public List<TipPregledaDTO> getTpkDTOs() {
        return tpkDTOs;
    }

    public void setTpkDTOs(List<TipPregledaDTO> tpkDTOs) {
        this.tpkDTOs = tpkDTOs;
    }
}
