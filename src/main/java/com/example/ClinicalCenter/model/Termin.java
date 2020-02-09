package com.example.ClinicalCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Termin {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "startTime", nullable = false)
    private Date pocetak;

    @Column(name = "endTime", nullable = false)
    private Date kraj;

    @Column(name = "Datum", nullable = false)
    private String datum;

    @Column(name = "Slobodan", nullable = false)
    private boolean slobodan=true;

    @Column(name = "odsustvo", nullable = false)
    private boolean odsustvo=false;

    @OneToOne
    private Pregled pregled;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Sala sala;

    public Termin() {
    }

    public Termin(Long id, Date pocetak, Date kraj) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
    }


    public Termin(Date pocetak, Date kraj, String datum, boolean slobodan, boolean odsustvo, Pregled pregled) {
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.datum = datum;
        this.slobodan = slobodan;
        this.odsustvo = odsustvo;
        this.pregled = pregled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPocetak() {
        return pocetak;
    }

    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    public Date getKraj() {
        return kraj;
    }

    public void setKraj(Date kraj) {
        this.kraj = kraj;
    }

    public Pregled getPregled() {
        return pregled;
    }

    public void setPregled(Pregled pregled) {
        this.pregled = pregled;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public boolean isSlobodan() {
        return slobodan;
    }

    public void setSlobodan(boolean slobodan) {
        this.slobodan = slobodan;
    }

    public boolean isOdsustvo() {
        return odsustvo;
    }

    public void setOdsustvo(boolean odsustvo) {
        this.odsustvo = odsustvo;
    }
}
