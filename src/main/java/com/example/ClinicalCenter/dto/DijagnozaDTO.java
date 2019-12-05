package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Dijagnoza;

public class DijagnozaDTO {

    private Long id;
    private String nazivDijagnoze;
    private String opisDijagnoze;

    public DijagnozaDTO() {
    }

    public DijagnozaDTO(Long id, String nazivDijagnoze, String opisDijagnoze) {
        this.id = id;
        this.nazivDijagnoze = nazivDijagnoze;
        this.opisDijagnoze = opisDijagnoze;
    }

    public DijagnozaDTO(Dijagnoza dijagnoza) {
        this.id=dijagnoza.getId();
        this.nazivDijagnoze=dijagnoza.getNazivDijagnoze();
        this.opisDijagnoze=dijagnoza.getOpisDijagnoze();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivDijagnoze() {
        return nazivDijagnoze;
    }

    public void setNazivDijagnoze(String nazivDijagnoze) {
        this.nazivDijagnoze = nazivDijagnoze;
    }

    public String getOpisDijagnoze() {
        return opisDijagnoze;
    }

    public void setOpisDijagnoze(String opisDijagnoze) {
        this.opisDijagnoze = opisDijagnoze;
    }
}
