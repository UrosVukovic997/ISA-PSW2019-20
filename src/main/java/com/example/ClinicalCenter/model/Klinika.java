package com.example.ClinicalCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Klinika {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "naziv", nullable = false)
    private String nazivKlinike;

    @Column(name = "grad", nullable = false)
    private String grad;

    @Column(name = "ocena", nullable = false)
    private double ocena=0.0;

    @OneToMany(mappedBy = "klinika", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Administrator> administrators;

    @OneToMany(mappedBy = "klinika", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Lekar> lekari;

    public Klinika() {
    }

    public Klinika(String nazivKlinike, String grad) {
        this.nazivKlinike = nazivKlinike;
        this.grad = grad;
        this.administrators = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivKlinike() {
        return nazivKlinike;
    }

    public void setNazivKlinike(String nazivKlinike) {
        this.nazivKlinike = nazivKlinike;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public Set<Administrator> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(Set<Administrator> administrators) {
        this.administrators = administrators;
    }

    public Set<Lekar> getLekari() {
        return lekari;
    }

    public void setLekari(Set<Lekar> lekari) {
        this.lekari = lekari;
    }
}
