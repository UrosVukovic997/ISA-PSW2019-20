package com.example.ClinicalCenter.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Entity
public class Karton {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "broj", nullable = false)
    private  Integer broj;

    @Column(name = "krvna_grupa", nullable = false)
    private  String krvnaGrupa;

    @Column(name = "dioptrija", nullable = false)
    private  String dioptrija;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Dijagnoza> dijagnoze;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Pregled> pregledi;

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    private Pacijent pacijent;

    public Karton() {
        this.pregledi = new HashSet<>();
        this.dijagnoze = new HashSet<>();

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

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
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
