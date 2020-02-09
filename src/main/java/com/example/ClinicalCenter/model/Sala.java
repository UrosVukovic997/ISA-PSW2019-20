package com.example.ClinicalCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sala {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String naziv;

    @Column(name = "number", nullable = false)
    private int broj;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Termin> terminiSale = new HashSet<Termin>();

    public Sala() {
    }

    public Sala(Long id, String naziv, int broj) {
        this.id = id;
        this.naziv = naziv;
        this.broj = broj;
    }
    /*
    public Sala(Sala s) {
        this(s.getId(),s.getNaziv(),s.getBroj());
    }
    */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public Set<Termin> getTerminiSale() {
        return terminiSale;
    }

    public void setTerminiSale(Set<Termin> terminiSale) {
        this.terminiSale = terminiSale;
    }
}

