package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Dijagnoza;
import com.example.ClinicalCenter.model.Lek;

import java.util.Set;

public class IzvestajLekarDTO {
    Long id;
    Integer jbo;
    String ime;
    String prezime;
    Set<Dijagnoza> dijagnoze;
    Set<Lek> lekovi;
    String text;

    public IzvestajLekarDTO() {
    }

    public IzvestajLekarDTO(Long id, Integer jbo, String ime, String prezime, Set<Dijagnoza> dijagnoze, Set<Lek> lekovi, String text) {
        this.id = id;
        this.jbo = jbo;
        this.ime = ime;
        this.prezime = prezime;
        this.dijagnoze = dijagnoze;
        this.lekovi = lekovi;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getJbo() {
        return jbo;
    }

    public void setJbo(Integer jbo) {
        this.jbo = jbo;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Set<Dijagnoza> getDijagnoze() {
        return dijagnoze;
    }

    public void setDijagnoze(Set<Dijagnoza> dijagnoze) {
        this.dijagnoze = dijagnoze;
    }

    public Set<Lek> getLekovi() {
        return lekovi;
    }

    public void setLekovi(Set<Lek> lekovi) {
        this.lekovi = lekovi;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
