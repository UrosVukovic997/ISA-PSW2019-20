package com.example.ClinicalCenter.model;

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

    @Column(name = "jbo", nullable = false)
    private String jbo;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "firstName", nullable = false)
    private String ime_pacijenta;

    @Column(name = "lastName", nullable = false)
    private String prezime_pacijenta;

    @Column(name = "town", nullable = true)
    private String grad;

    @Column(name = "nationality", nullable = false)
    private String drzavljanstvo;

    @Column(name = "emergency", nullable = false)
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

    @OneToOne
    private Termin termin;

    @OneToOne
    private TipPregleda tipPregleda;

    @OneToOne
    private Lekar lekar;

    @OneToOne
    private Pacijent pacijent;

    public Pregled() {
    }

    public Pregled(Long id, String jbo, String email, String ime_pacijenta, String prezime_pacijenta, String grad, String drzavljanstvo, String hitnost, boolean obavljen, boolean obrisan, boolean pregled, boolean operacija) {
        this.id = id;
        this.jbo = jbo;
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

    public String getJbo() {
        return jbo;
    }

    public void setJbo(String jbo) {
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
}
