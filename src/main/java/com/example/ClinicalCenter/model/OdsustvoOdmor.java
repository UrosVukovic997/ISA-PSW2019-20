package com.example.ClinicalCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OdsustvoOdmor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "begin", nullable = false)
    private Date pocetak;

    @Column(name = "end", nullable = false)
    private Date kraj;

    @Column(name = "vacation", nullable = false)
    private Boolean godisnji;

    @Column(name = "absence", nullable = false)
    private Boolean odsustvo;

    @Column(name = "reason", nullable = false)
    private String obrazlozenje;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Lekar lekar;

    public OdsustvoOdmor() {
    }

    public OdsustvoOdmor(long id, Date pocetak, Date kraj, Boolean godisnji, Boolean odsustvo, String obrazlozenje) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.godisnji = godisnji;
        this.odsustvo = odsustvo;
        this.obrazlozenje = obrazlozenje;
    }

    public OdsustvoOdmor(Date pocetak, Date kraj, Boolean godisnji, Boolean odsustvo, String obrazlozenje) {
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.godisnji = godisnji;
        this.odsustvo = odsustvo;
        this.obrazlozenje = obrazlozenje;
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

    public Boolean getGodisnji() {
        return godisnji;
    }

    public void setGodisnji(Boolean godisnji) {
        this.godisnji = godisnji;
    }

    public Boolean getOdsustvo() {
        return odsustvo;
    }

    public void setOdsustvo(Boolean odsustvo) {
        this.odsustvo = odsustvo;
    }

    public Lekar getLekar() { return lekar; }

    public void setLekar(Lekar lekar) { this.lekar = lekar; }

    public String getObrazlozenje() { return obrazlozenje; }

    public void setObrazlozenje(String obrazlozenje) { this.obrazlozenje = obrazlozenje; }
}
