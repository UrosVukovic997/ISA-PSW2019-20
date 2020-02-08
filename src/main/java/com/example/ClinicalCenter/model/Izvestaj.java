package com.example.ClinicalCenter.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Izvestaj {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany( fetch = FetchType.EAGER)
    private Set<Dijagnoza> dijagnoze;

    @Column(name = "text", nullable = false)
    private String text;

    @OneToOne
    private Recept recept;

    public Izvestaj() {
        dijagnoze=new HashSet<>();
    }

    public Izvestaj(Set<Dijagnoza> dijagnoze, String text, Recept recept) {
        this.dijagnoze = dijagnoze;
        this.text = text;
        this.recept = recept;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Dijagnoza> getDijagnoze() {
        return dijagnoze;
    }

    public void setDijagnoze(Set<Dijagnoza> dijagnoze) {
        this.dijagnoze = dijagnoze;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Recept getRecept() {
        return recept;
    }

    public void setRecept(Recept recept) {
        this.recept = recept;
    }
}
