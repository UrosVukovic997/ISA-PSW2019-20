package com.example.ClinicalCenter.dto;

import java.sql.Time;
import java.util.Date;

public class TerminPacDTO {
    private String parsirano1;

    public TerminPacDTO(String parsirano1) {
        this.parsirano1 = parsirano1;
    }

    public String getParsirano1() {
        return parsirano1;
    }

    public void setParsirano1(String parsirano1) {
        this.parsirano1 = parsirano1;
    }
}
