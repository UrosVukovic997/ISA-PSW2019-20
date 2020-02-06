package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Dijagnoza;
import com.example.ClinicalCenter.model.Karton;
import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.model.Pregled;

import java.util.Set;

public class KartonDTO {

    private long id;
    private Integer broj;
    private  String krvnaGrupa;
    private  String dioptrija;
    private Set<Dijagnoza> dijagnoze;
    private Set<Pregled> pregledi;
    private Integer jbo;
    private String ime;
    private String prezime;


    public KartonDTO() {
    }

    public KartonDTO(Karton karton) {
        this.id = karton.getId();
        this.broj = karton.getBroj();
        this.krvnaGrupa = karton.getKrvnaGrupa();
        this.dioptrija = karton.getDioptrija();
        this.dijagnoze = karton.getDijagnoze();
        this.pregledi = karton.getPregledi();
        this.jbo = karton.getPacijent().getJbo();
        this.ime = karton.getPacijent().getImePacijenta();
        this.prezime = karton.getPacijent().getPrezimePacijenta();
    }

    public KartonDTO(long id, Integer broj, String krvnaGrupa, String dioptrija, Set<Dijagnoza> dijagnoze,
                     Set<Pregled> pregledi, Integer jbo, String ime, String prezime) {
        this.id = id;
        this.broj = broj;
        this.krvnaGrupa = krvnaGrupa;
        this.dioptrija = dioptrija;
        this.dijagnoze = dijagnoze;
        this.pregledi = pregledi;
        this.jbo = jbo;
        this.ime = ime;
        this.prezime = prezime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getBroj() {
        return broj;
    }

    public void setBroj(Integer broj) {
        this.broj = broj;
    }

    public Set<Dijagnoza> getDijagnoze() {
        return dijagnoze;
    }

    public void setDijagnoze(Set<Dijagnoza> dijagnoze) {
        this.dijagnoze = dijagnoze;
    }

    public Set<Pregled> getPregledi() {
        return pregledi;
    }

    public void setPregledi(Set<Pregled> pregledi) {
        this.pregledi = pregledi;
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
}
