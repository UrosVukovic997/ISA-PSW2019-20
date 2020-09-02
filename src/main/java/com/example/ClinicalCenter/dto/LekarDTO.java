package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Klinika;
import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.model.Pacijent;

import java.util.Set;

public class LekarDTO {

    private long id;
    private String ime;
    private String prezime;
    private Set<Pacijent> pacijenti;
    private String email;
    private String specijalnost;
    private String korIme;
    private String lozinka;
    private String adresa;
    private String opis;

    public LekarDTO() {
    }

    public LekarDTO(Lekar lekar) {
        this(lekar.getId(),lekar.getIme(),lekar.getPrezime(),
            lekar.getPacijenti(),lekar.getEmail(),lekar.getSpecijalnost(),
                lekar.getKorIme(),lekar.getLozinka(),lekar.getAdresa(),lekar.getOpis());
    }

    public LekarDTO(long id, String ime, String prezime, Set<Pacijent> pacijenti,  String email, String specijalnost, String korIme, String lozinka, String adresa, String opis) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.pacijenti = pacijenti;
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

    public String getKorIme() { return korIme; }

    public void setKorIme(String korIme) { this.korIme = korIme; }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getAdresa() { return adresa; }

    public void setAdresa(String adresa) { this.adresa = adresa; }

    public String getOpis() { return opis; }

    public void setOpis(String opis) { this.opis = opis; }
}
