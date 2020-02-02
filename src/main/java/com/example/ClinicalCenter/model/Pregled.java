package com.example.ClinicalCenter.model;

import java.util.Date;
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

public class Pregled {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String ime_pacijenta;

    @Column(name = "lastName", nullable = false)
    private String prezime_pacijenta;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "jbo", nullable = false)
    private String jbo;

    @Column(name = "date", nullable = false)
    private Date termin;

}
