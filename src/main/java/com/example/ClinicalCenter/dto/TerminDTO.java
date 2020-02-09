package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Pregled;
import com.example.ClinicalCenter.model.Termin;

import java.util.Date;

public class TerminDTO {

    private long id;
    private Date pocetak;
    private Date kraj;
    private Pregled pregled;

    public TerminDTO() {
    }

    public TerminDTO(Termin termin) {
        this(termin.getId(),termin.getPocetak(),termin.getKraj(),termin.getPregled());
    }

    public TerminDTO(long id, Date pocetak, Date kraj, Pregled pregled) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.pregled = pregled;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
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
