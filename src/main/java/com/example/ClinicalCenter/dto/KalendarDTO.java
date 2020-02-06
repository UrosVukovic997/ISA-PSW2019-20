package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Kalendar;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;


import java.sql.Date;
import java.sql.Time;

public class KalendarDTO {

    private Long id;
    private DateTime datum;
    private String naslov;
    private String opis;
    private String osobljeUsername;
    private String role;
    private String pacijent;
    private String tip;

    public KalendarDTO() {
        id = (long)1232;
        datum= new DateTime();
        naslov= "proba";
        opis= "valjda uspe";
    }

    public KalendarDTO(Long id, DateTime datum, String naslov, String opis, String osobljeUsername, String role, String pacijent, String tip) {
        this.id = id;
        this.datum = datum;
        this.naslov = naslov;
        this.opis = opis;
        this.osobljeUsername = osobljeUsername;
        this.role = role;
        this.pacijent = pacijent;
        this.tip = tip;
    }

    public KalendarDTO(Kalendar kalendar) {
        this.id = kalendar.getId();
        this.datum = kalendar.getDatum();
        this.naslov = kalendar.getNaslov();
        this.opis = kalendar.getOpis();
        this.pacijent = kalendar.getPacijent();
        this.tip = kalendar.getTip();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatum() {
        return datum.toString();
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

    public String getOsobljeUsername() {
        return osobljeUsername;
    }

    public void setOsobljeUsername(String osobljeUsername) {
        this.osobljeUsername = osobljeUsername;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
