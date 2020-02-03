package com.example.ClinicalCenter.model;

import javax.persistence.*;

@Entity
public class TipPregleda {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String naziv;

    @Column(name = "deleted", nullable = false)
    private boolean obrisan;

    @Column(name = "price", nullable = false)
    private Double cena;

    @OneToOne
    private Pregled pregled;

    public TipPregleda() {
    }

    public TipPregleda(Long id, String naziv, boolean obrisan, Double cena) {
        this.id = id;
        this.naziv = naziv;
        this.obrisan = obrisan;
        this.cena = cena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Pregled getPregled() {
        return pregled;
    }

    public void setPregled(Pregled pregled) {
        this.pregled = pregled;
    }
}
