package com.example.ClinicalCenter.model;

import javax.persistence.*;
import java.util.Date;

public class Termin {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "startTime", nullable = false)
    private Date pocetak;

    @Column(name = "endTime", nullable = false)
    private Date kraj;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Pregled pregled;


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
}
