package com.example.ClinicalCenter;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Pacijent extends Korisnik {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ImePacijenta", nullable = false)
    private String ImePacijenta;

    @Column(name = "PrezimePacijenta", nullable = false)
    private String PrezimePacijenta;

    public Pacijent() {
        super();
    }

    public Pacijent(Long id, String ImePacijenta, String PrezimePacijenta) {
        super();
        this.id = id;
        this.ImePacijenta = ImePacijenta;
        this.PrezimePacijenta = PrezimePacijenta;
    }

    public String getPrezimePacijenta() {
        return PrezimePacijenta;
    }

    public void setPrezimePacijenta(String prezimePacijenta) {
        PrezimePacijenta = prezimePacijenta;
    }

    public Long getId() {
        return id;
    }

    public String getImePacijenta() {
        return ImePacijenta;
    }

    public void setImePacijenta(String ImePacijenta) {
        this.ImePacijenta = ImePacijenta;
    }
}
