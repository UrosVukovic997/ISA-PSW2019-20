package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.*;

import java.util.Date;

public class PregledDTO {

    private long id;
    private String imePacijenta;
    private String tipPregledaStr;
    private String prezimePacijenta;
    private String email;
    private String jbo;
    private String grad;
    private String drzavljanstvo;
    private String hitnost;
    private boolean obavljen;
    private boolean obrisan;
    private boolean pregled;
    private  boolean operacija;
    private Pacijent pacijent;
    private TipPregleda tipPregleda;
    private Lekar lekar;
    private Termin termin;
    private Date pocetak;
    private Date kraj;

    public PregledDTO() {
    }

    public PregledDTO(Pregled pregled) {
        this.id = pregled.getId();
        this.imePacijenta = pregled.getIme_pacijenta();
        this.prezimePacijenta = pregled.getPrezime_pacijenta();
        this.email = pregled.getEmail();
        this.jbo = pregled.getJbo();
        this.grad = pregled.getGrad();
        this.drzavljanstvo = pregled.getDrzavljanstvo();
        this.hitnost = pregled.getHitnost();
        this.obavljen = pregled.isObavljen();
        this.obrisan = pregled.isObrisan();
        this.pregled = pregled.isPregled();
        this.operacija = pregled.isOperacija();
        this.pacijent = pregled.getPacijent();
        this.tipPregleda = pregled.getTipPregleda();
        this.lekar = pregled.getLekar();
        this.termin = pregled.getTermin();
    }

    public PregledDTO(long id, String imePacijenta, String tipPregledaStr, String prezimePacijenta, String email, String jbo, String grad, String drzavljanstvo, String hitnost, boolean obavljen, boolean obrisan, boolean pregled, boolean operacija, Date pocetak, Date kraj) {
        this.id = id;
        this.imePacijenta = imePacijenta;
        this.tipPregledaStr = tipPregledaStr;
        this.prezimePacijenta = prezimePacijenta;
        this.email = email;
        this.jbo = jbo;
        this.grad = grad;
        this.drzavljanstvo = drzavljanstvo;
        this.hitnost = hitnost;
        this.obavljen = obavljen;
        this.obrisan = obrisan;
        this.pregled = pregled;
        this.operacija = operacija;
        this.pocetak = pocetak;
        this.kraj = kraj;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImePacijenta() {
        return imePacijenta;
    }

    public void setImePacijenta(String imePacijenta) {
        this.imePacijenta = imePacijenta;
    }

    public String getPrezimePacijenta() {
        return prezimePacijenta;
    }

    public void setPrezimePacijenta(String prezimePacijenta) {
        this.prezimePacijenta = prezimePacijenta;
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

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
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

    public String getTipPregledaStr() {
        return tipPregledaStr;
    }

    public void setTipPregledaStr(String tipPregledaStr) {
        this.tipPregledaStr = tipPregledaStr;
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
