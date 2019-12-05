package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Lek;

public class LekDTO {

    private Long id;
    private String nazivLeka;
    private String opisLeka;

    public LekDTO() {
    }

    public LekDTO(Long id, String nazivLeka, String opisLeka) {
        this.id = id;
        this.nazivLeka = nazivLeka;
        this.opisLeka = opisLeka;
    }

    public LekDTO(Lek lek) {
        this.id = lek.getId();
        this.nazivLeka = lek.getNazivLeka();
        this.opisLeka = lek.getOpisLeka();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivLeka() {
        return nazivLeka;
    }

    public void setNazivLeka(String nazivLeka) {
        this.nazivLeka = nazivLeka;
    }

    public String getOpisLeka() {
        return opisLeka;
    }

    public void setOpisLeka(String opisLeka) {
        this.opisLeka = opisLeka;
    }
}
