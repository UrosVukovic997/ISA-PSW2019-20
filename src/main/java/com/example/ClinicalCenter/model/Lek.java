package com.example.ClinicalCenter.model;

import javax.persistence.*;

@Entity
public class Lek {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nazivDijagnoze", nullable = false)
    private String nazivLeka;

    @Column(name = "opisDijagnoze", nullable = true)
    private String opisLeka;

    public Lek() {
    }

    public Lek(String nazivLeka, String opisLeka) {
        this.nazivLeka = nazivLeka;
        this.opisLeka = opisLeka;
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
