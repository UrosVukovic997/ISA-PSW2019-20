package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.OdsustvoOdmor;

import java.util.Date;

public class OdsustvoOdmorDTO {

    private Long id;
    private Date pocetak;
    private Date kraj;
    private boolean godisnji;
    private boolean odsustvo;
    private String obrazlozenje;

    public OdsustvoOdmorDTO() {
    }

    public OdsustvoOdmorDTO(OdsustvoOdmor odsustvoOdmor) {
        this(odsustvoOdmor.getId(), odsustvoOdmor.getPocetak(), odsustvoOdmor.getKraj(), odsustvoOdmor.getGodisnji(), odsustvoOdmor.getOdsustvo(), odsustvoOdmor.getObrazlozenje());
    }

    public OdsustvoOdmorDTO(Long id, Date pocetak, Date kraj, Boolean godisnji, Boolean odsustvo, String obrazlozenje) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.godisnji = godisnji;
        this.odsustvo = odsustvo;
        this.obrazlozenje = obrazlozenje;
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

    public boolean isGodisnji() { return godisnji; }

    public void setGodisnji(boolean godisnji) { this.godisnji = godisnji; }

    public boolean isOdsustvo() { return odsustvo; }

    public void setOdsustvo(boolean odsustvo) { this.odsustvo = odsustvo; }

    public String getObrazlozenje() { return obrazlozenje; }

    public void setObrazlozenje(String obrazlozenje) { this.obrazlozenje = obrazlozenje; }
}
