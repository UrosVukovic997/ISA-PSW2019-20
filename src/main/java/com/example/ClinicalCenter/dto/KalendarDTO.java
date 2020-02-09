package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Kalendar;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;


import java.sql.Date;
import java.sql.Time;

public class KalendarDTO {

    private String start;
    private String end;
    private String naslov;
    private String jbo;

    public KalendarDTO() {
    }

    public KalendarDTO(String start, String end, String naslov, String jbo) {
        this.start = start;
        this.end = end;
        this.naslov = naslov;
        this.jbo = jbo;
    }


    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getJbo() {
        return jbo;
    }

    public void setJbo(String jbo) {
        this.jbo = jbo;
    }
}
