package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Lek;
import com.example.ClinicalCenter.model.Recept;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class ReceptDTO {

    private Long id;
    private String imePacijenta;
    private Integer jboPacijenta;
    private String imeLekara;
    private String klinika;
    private Set<Lek> lekovi;

    public ReceptDTO() {
    }

    public ReceptDTO(Long id, String imePacijenta, Integer jboPacijenta, String imeLekara, String klinika, Set<Lek> lekovi, boolean overen) {
        this.id = id;
        this.imePacijenta = imePacijenta;
        this.jboPacijenta = jboPacijenta;
        this.imeLekara = imeLekara;
        this.klinika = klinika;
        this.lekovi = lekovi;
    }
    public ReceptDTO(Recept recept) {
        this.id = recept.getId();
        this.imePacijenta = recept.getImePacijenta();
        this.jboPacijenta = recept.getJboPacijenta();
        this.imeLekara = recept.getImeLekara();
        this.klinika = recept.getKlinika();
        this.lekovi = recept.getLekovi();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImePacijenta() {
        return imePacijenta;
    }

    public void setImePacijenta(String imePacijenta) {
        this.imePacijenta = imePacijenta;
    }

    public Integer getJboPacijenta() {
        return jboPacijenta;
    }

    public void setJboPacijenta(Integer jboPacijenta) {
        this.jboPacijenta = jboPacijenta;
    }

    public String getImeLekara() {
        return imeLekara;
    }

    public void setImeLekara(String imeLekara) {
        this.imeLekara = imeLekara;
    }

    public String getKlinika() {
        return klinika;
    }

    public void setKlinika(String klinika) {
        this.klinika = klinika;
    }

    public Set<Lek> getLekovi() {
        return lekovi;
    }

    public void setLekovi(Set<Lek> lekovi) {
        this.lekovi = lekovi;
    }

}
