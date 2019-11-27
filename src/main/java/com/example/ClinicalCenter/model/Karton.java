package com.example.ClinicalCenter.model;

import javax.persistence.*;
import java.util.Set;



@Entity
public class Karton {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "broj", nullable = false)
    private  Integer broj;    /*zbog baze*/

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Dijagnoza> dijagnoze;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Pregled> pregledi;

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    private Pacijent pacijent;


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

}
