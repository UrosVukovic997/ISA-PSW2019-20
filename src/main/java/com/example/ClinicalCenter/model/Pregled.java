package com.example.ClinicalCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Pregled {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "firstName", nullable = true)
    private String ime_pacijenta;

    @Column(name = "lastName", nullable = true)
    private String prezime_pacijenta;

    @Column(name = "town", nullable = true)
    private String grad;

    @Column(name = "nationality", nullable = true)
    private String drzavljanstvo;

    @Column(name = "emergency", nullable = true)
    private String hitnost;

    @Column(name = "done", nullable = false)
    private boolean obavljen;

    @Column(name = "deleted", nullable = false)
    private boolean obrisan;

    @Column(name = "visit", nullable = false)
    private boolean pregled;

    @Column(name = "operation", nullable = false)
    private boolean operacija;

    private Date pocetak;
    private  Date kraj;
    @Column(name = "jbo", nullable = false)
    private int jbo;

    @OneToOne
    @JsonIgnore
    private Termin termin;

    @OneToOne
    private TipPregleda tipPregleda;

    @OneToOne
    private Lekar lekar;

    @OneToOne
    private Pacijent pacijent;

    @OneToOne
    private Izvestaj izvestaj;

    public Pregled() {
    }

    public Pregled(String email, String ime_pacijenta, String prezime_pacijenta, String grad, String drzavljanstvo,
                   String hitnost, boolean obavljen, boolean obrisan, boolean pregled, boolean operacija, Date pocetak, Date kraj, int jbo,
                   Termin termin, TipPregleda tipPregleda, Lekar lekar, Pacijent pacijent, Izvestaj izvestaj) {
        this.email = email;
        this.ime_pacijenta = ime_pacijenta;
        this.prezime_pacijenta = prezime_pacijenta;
        this.grad = grad;
        this.drzavljanstvo = drzavljanstvo;
        this.hitnost = hitnost;
        this.obavljen = obavljen;
        this.obrisan = obrisan;
        this.pregled = pregled;
        this.operacija = operacija;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.jbo = jbo;
        this.termin = termin;
        this.tipPregleda = tipPregleda;
        this.lekar = lekar;
        this.pacijent = pacijent;
        this.izvestaj = izvestaj;
    }

    public Pregled(boolean obavljen, boolean obrisan, boolean pregled, boolean operacija,
                   int jbo, Termin termin, Lekar lekar, Pacijent pacijent) {
        this.obavljen = obavljen;
        this.obrisan = obrisan;
        this.pregled = pregled;
        this.operacija = operacija;
        this.jbo = jbo;
        this.termin = termin;
        this.tipPregleda = tipPregleda;
        this.lekar = lekar;
        this.pacijent = pacijent;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme_pacijenta() {
        return ime_pacijenta;
    }

    public void setIme_pacijenta(String ime_pacijenta) {
        this.ime_pacijenta = ime_pacijenta;
    }

    public String getPrezime_pacijenta() {
        return prezime_pacijenta;
    }

    public void setPrezime_pacijenta(String prezime_pacijenta) {
        this.prezime_pacijenta = prezime_pacijenta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getJbo() {
        return jbo;
    }

    public void setJbo(int jbo) {
        this.jbo = jbo;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(String drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }

    public String getHitnost() {
        return hitnost;
    }

    public void setHitnost(String hitnost) {
        this.hitnost = hitnost;
    }

    public boolean isObavljen() {
        return obavljen;
    }

    public void setObavljen(boolean obavljen) {
        this.obavljen = obavljen;
    }

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }

    public TipPregleda getTipPregleda() {
        return tipPregleda;
    }

    public void setTipPregleda(TipPregleda tipPregleda) {
        this.tipPregleda = tipPregleda;
    }

    public Lekar getLekar() {
        return lekar;
    }

    public void setLekar(Lekar lekar) {
        this.lekar = lekar;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public boolean isPregled() {
        return pregled;
    }

    public void setPregled(boolean pregled) {
        this.pregled = pregled;
    }

    public boolean isOperacija() {
        return operacija;
    }

    public void setOperacija(boolean operacija) {
        this.operacija = operacija;
    }

    public Date getPocetak() {
        return pocetak;
    }

    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    public Date getKraj() {
        return kraj;
    }

    public void setKraj(Date kraj) {
        this.kraj = kraj;
    }

    public Izvestaj getIzvestaj() {
        return izvestaj;
    }

    public void setIzvestaj(Izvestaj izvestaj) {
        this.izvestaj = izvestaj;
    }


}
