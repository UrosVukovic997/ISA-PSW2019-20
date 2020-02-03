package com.example.ClinicalCenter.model;

import com.example.ClinicalCenter.dto.KalendarDTO;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;


@Entity
public class Kalendar {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datum", nullable = false)
    private DateTime datum;


    @Column(name = "naslov", nullable = false)
    private String naslov;

    @Column(name = "opis", nullable = false)
    private String opis;

    @Column(name = "pacijent", nullable = false)
    private String pacijent;

    @Column(name = "tip", nullable = false)
    private String tip;

    public Kalendar() {
    }

    public Kalendar(DateTime datum, String naslov, String opis, String pacijent, String tip) {
        this.datum = datum;
        this.naslov = naslov;
        this.opis = opis;
        this.pacijent = pacijent;
        this.tip = tip;
    }

    public Kalendar(KalendarDTO kalendarDTO) {
        this.datum =DateTime.parse(kalendarDTO.getDatum());
        this.naslov = kalendarDTO.getNaslov();
        this.opis = kalendarDTO.getOpis();
        this.pacijent = kalendarDTO.getPacijent();
        this.tip = kalendarDTO.getTip();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getDatum() {
        return datum;
    }

    public void setDatum(DateTime datum) {
        this.datum = datum;
    }


    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getPacijent() {
        return pacijent;
    }

    public void setPacijent(String pacijent) {
        this.pacijent = pacijent;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
