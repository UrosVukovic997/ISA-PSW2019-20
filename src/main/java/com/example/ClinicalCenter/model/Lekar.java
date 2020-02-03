package com.example.ClinicalCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Lekar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstName", nullable = false)
    private String ime;

    @Column(name = "lastName", nullable = false)
    private String prezime;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "spec", nullable = false)
    private String specijalnost;

    @Column(name = "username", nullable = false)
    private String korIme;

    @Column(name = "password", nullable = false)
    private String lozinka;

    @Column(name = "home_adress", nullable = false)
    private String adresa;

    @Column(name = "description", nullable = false)
    private String opis;


    @OneToMany(mappedBy = "lekar", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Pacijent> pacijenti = new HashSet<Pacijent>();

    @OneToMany(mappedBy = "lekar", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<OdsustvoOdmor> odsustvoOdmori = new HashSet<OdsustvoOdmor>();


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Klinika klinika;

    public Lekar() {
        super();
    }

    public Lekar(Long id, String ime, String prezime, String email, String specijalnost, String korIme, String lozinka, String adresa, String opis) {
        super();
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.specijalnost = specijalnost;
        this.korIme = korIme;
        this.lozinka = lozinka;
        this.adresa = adresa;
        this.opis = opis;
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

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSpecijalnost() { return specijalnost; }

    public void setSpecijalnost(String specijalnost) { this.specijalnost = specijalnost; }

    public String getKorIme() { return korIme; }

    public void setKorIme(String korIme) {
        this.korIme = korIme;
    }

    public String getLozinka() { return lozinka; }

    public void setLozinka(String lozinka) { this.lozinka = lozinka; }

    public Set<Pacijent> getPacijenti() {
        return pacijenti;
    }

    public void setPacijenti(Set<Pacijent> pacijenti) {
        this.pacijenti = pacijenti;
    }

    public Klinika getKlinika() { return klinika; }

    public void setKlinika(Klinika klinika) { this.klinika = klinika; }

    public String getAdresa() { return adresa; }

    public void setAdresa(String adresa) { this.adresa = adresa; }

    public String getOpis() { return opis; }

    public void setOpis(String opis) { this.opis = opis; }

    public Set<OdsustvoOdmor> getOdsustvoOdmori() { return odsustvoOdmori; }

    public void setOdsustvoOdmori(Set<OdsustvoOdmor> odsustvoOdmori) { this.odsustvoOdmori = odsustvoOdmori; }
}
