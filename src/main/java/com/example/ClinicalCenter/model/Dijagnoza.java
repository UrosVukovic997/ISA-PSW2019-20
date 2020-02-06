package com.example.ClinicalCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
public class Dijagnoza {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nazivDijagnoze", nullable = false)
    private String nazivDijagnoze;

    @Column(name = "opisDijagnoze", nullable = true)
    private String opisDijagnoze;


    public Dijagnoza() {
    }

    public Dijagnoza(String nazivDijagnoze, String opisDijagnoze) {
        this.nazivDijagnoze = nazivDijagnoze;
        this.opisDijagnoze = opisDijagnoze;
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

