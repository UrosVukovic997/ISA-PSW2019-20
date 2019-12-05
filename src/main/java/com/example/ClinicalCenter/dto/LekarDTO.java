package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.model.Pacijent;

import java.util.Set;

public class LekarDTO {

    private long id;
    private String ime;
    private String prezime;
    private Set<Pacijent> pacijenti;


    public LekarDTO() {
    }

    public LekarDTO(Lekar lekar) {
        this(lekar.getId(),lekar.getIme(),lekar.getPrezime(),lekar.getPacijenti());
    }

    public LekarDTO(long id, String ime, String prezime, Set<Pacijent> pacijenti) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.pacijenti = pacijenti;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<Pacijent> getPacijenti() {
        return pacijenti;
    }

    public void setPacijenti(Set<Pacijent> pacijenti) {
        this.pacijenti = pacijenti;
    }

}
