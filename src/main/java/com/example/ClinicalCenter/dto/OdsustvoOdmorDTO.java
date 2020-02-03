package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.OdsustvoOdmor;

import java.util.Date;

public class OdsustvoOdmorDTO {

    private Long id;
    private Date pocetak;
    private Date kraj;
    private Boolean godisnji;
    private Boolean odsustvo;

    public OdsustvoOdmorDTO() {
    }

    public OdsustvoOdmorDTO(OdsustvoOdmor odsustvoOdmor) {
        this(odsustvoOdmor.getId(), odsustvoOdmor.getPocetak(), odsustvoOdmor.getKraj(), odsustvoOdmor.getGodisnji(), odsustvoOdmor.getOdsustvo());
    }

    public OdsustvoOdmorDTO(Long id, Date pocetak, Date kraj, Boolean godisnji, Boolean odsustvo) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.godisnji = godisnji;
        this.odsustvo = odsustvo;
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
}
