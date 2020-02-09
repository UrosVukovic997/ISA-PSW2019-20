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
    }
}
