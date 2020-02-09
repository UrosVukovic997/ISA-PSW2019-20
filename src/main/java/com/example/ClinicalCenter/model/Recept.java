package com.example.ClinicalCenter.model;

import com.example.ClinicalCenter.dto.ReceptDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recept {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imePacijenta", nullable = false)
    private String imePacijenta;

    @Column(name = "JboPacijenta", nullable = false)
    private Integer jboPacijenta;

    @Column(name = "imeLekara", nullable = false)
    private String imeLekara;

    @Column(name = "klinika", nullable = false)
    private String klinika;

    @Column(name = "overen", nullable = false)
    private boolean overen;

    @Column(name = "overila", nullable = true)
    private String overila;


    @OneToMany(fetch = FetchType.EAGER)
    private Set<Lek> lekovi;

    public Recept(String imePacijenta, Integer jboPacijenta, String imeLekara, String klinika, Set<Lek> lekovi, boolean overen) {
        this.imePacijenta = imePacijenta;
        this.jboPacijenta = jboPacijenta;
        this.imeLekara = imeLekara;
        this.klinika = klinika;
        this.lekovi = lekovi;
        this.overen = overen;
    }



    public Recept(ReceptDTO recept) {
        this.imePacijenta = recept.getImePacijenta();
        this.jboPacijenta = recept.getJboPacijenta();
        this.imeLekara = recept.getImeLekara();
        this.klinika = recept.getKlinika();
        this.lekovi = recept.getLekovi();
    }

    public Recept() {
        this.lekovi = new HashSet<>();
        this.overen = false;
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

    public boolean isOveren() {
        return overen;
    }

    public void setOveren(boolean overen) {
        this.overen = overen;
    }

    public String getOverila() {
        return overila;
    }

    public void setOverila(String overila) {
        this.overila = overila;
    }
}
