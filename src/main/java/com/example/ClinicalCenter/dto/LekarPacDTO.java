package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.model.Pacijent;

import java.util.Set;

public class LekarPacDTO {

    private long id;
    private String ime;
    private String prezime;
    private Set<Pacijent> pacijenti;
    private String email;
    private String specijalnost;
    private String korIme;
    private String adresa;
    private String opis;
    private Double prosecna_ocena;

    public LekarPacDTO(long id, String ime, String prezime, Set<Pacijent> pacijenti, String email, String specijalnost, String korIme, String adresa, String opis, Double prosecna_ocena) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.pacijenti = pacijenti;
        this.email = email;
        this.specijalnost = specijalnost;
        this.korIme = korIme;
        this.adresa = adresa;
        this.opis = opis;
        this.prosecna_ocena = prosecna_ocena;
    }

    public LekarPacDTO(Lekar lekar) {
        this(lekar.getId(),lekar.getIme(),lekar.getPrezime(),
                lekar.getPacijenti(),lekar.getEmail(),lekar.getSpecijalnost(),lekar.getKorIme(),lekar.getAdresa(),lekar.getOpis(),lekar.getProsecna_ocena());
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

    public Set<Pacijent> getPacijenti() {
        return pacijenti;
    }

    public void setPacijenti(Set<Pacijent> pacijenti) {
        this.pacijenti = pacijenti;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecijalnost() {
        return specijalnost;
    }

    public void setSpecijalnost(String specijalnost) {
        this.specijalnost = specijalnost;
    }

    public String getKorIme() {
        return korIme;
    }

    public void setKorIme(String korIme) {
        this.korIme = korIme;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getProsecna_ocena() {
        return prosecna_ocena;
    }

    public void setProsecna_ocena(Double prosecna_ocena) {
        this.prosecna_ocena = prosecna_ocena;
    }
}
