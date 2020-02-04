package com.example.ClinicalCenter.model;


import com.fasterxml.jackson.annotation.JsonIgnore;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Pacijent {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ime", nullable = false)
    private String imePacijenta;

    @Column(name = "prezime", nullable = false)
    private String prezimePacijenta;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "adresaPrebivalista", nullable = false)
    private String adresa;

    @Column(name = "grad", nullable = false)
    private String grad;

    @Column(name = "drzava", nullable = false)
    private String drzava;

    @Column(name = "brojTelefona", nullable = false)
    private String brojTelefona;

    @Column(name = "jbo", nullable = false)
    private Integer jbo;

    @Column(name = "odobren", nullable = false)
    private Boolean odobren;

    @Column(name = "datum_rodj", nullable = false)
    private String rodjen;

    @Column(name = "potvrdio", nullable = false)
    private Boolean potvrdio;





    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Lekar lekar;


    public Pacijent() {
        imePacijenta = "";
        prezimePacijenta = "";
        email = "";
        password= "";
        adresa = "";
        grad = "";
        drzava = "";
        brojTelefona = "";
        jbo = 0;
        odobren = false;
        username="";
        lekar = null;
        rodjen = "1988-10-06";
    }

    public Pacijent(Long id, String imePacijenta, String prezimePacijenta, String email, String lozinka, String adresa, String grad, String drzava, String brojTelefona, Integer jbo, Boolean odobren, String username, Lekar lekar, String rodjen) {
        this.id = id;
        this.imePacijenta = imePacijenta;
        this.prezimePacijenta = prezimePacijenta;
        this.email = email;
        this.password = lozinka;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.brojTelefona = brojTelefona;
        this.jbo = jbo;
        this.odobren = odobren;
        this.potvrdio = false;
        this.username= username;
        this.lekar = lekar;
        this.rodjen = rodjen;
    }

    public Lekar getLekar() { return lekar; }

    public void setLekar(Lekar lekar) { this.lekar = lekar; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public Integer getJbo() {
        return jbo;
    }


    public void setJbo(Integer jbo) {
        this.jbo = jbo;

    }

    public Boolean getOdobren() {
        return odobren;
    }

    public void setOdobren(Boolean odobren) {
        this.odobren = odobren;
    }

    public Boolean getPotvrdio() {
        return potvrdio;
    }

    public void setPotvrdio(Boolean potvrdio) {
        this.potvrdio = potvrdio;
    }



    public String getRodjen() { return rodjen; }

    public void setRodjen(String rodjen) { this.rodjen = rodjen; }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
