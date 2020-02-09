package com.example.ClinicalCenter.dto;

public class KartonPacDTO {
    private  Integer broj;
    private  String krvnaGrupa;
    private  String dioptrija;
    private Integer jbo;

    public KartonPacDTO(Integer jbo, Integer broj, String krvnaGrupa, String dioptrija) {
        this.broj = broj;
        this.krvnaGrupa = krvnaGrupa;
        this.dioptrija = dioptrija;
        this.jbo = jbo;
    }

    public Integer getBroj() {
        return broj;
    }

    public void setBroj(Integer broj) {
        this.broj = broj;
    }

    public String getKrvnaGrupa() {
        return krvnaGrupa;
    }

    public void setKrvnaGrupa(String krvnaGrupa) {
        this.krvnaGrupa = krvnaGrupa;
    }

    public String getDioptrija() {
        return dioptrija;
    }

    public void setDioptrija(String dioptrija) {
        this.dioptrija = dioptrija;
    }

    public Integer getJbo() {
        return jbo;
    }

    public void setJbo(Integer jbo) {
        this.jbo = jbo;
    }
}
