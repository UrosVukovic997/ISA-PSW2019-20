package com.example.ClinicalCenter.dto;

public class SearchKlinPacDTO {
    private String nazivKlinike;
    private double ocenaKlinike;
    private String adresaKlinike;
    private double cenaPregleda;

    public SearchKlinPacDTO(String nazivKlinike, double ocena, String adresaKlinike, double cenaPregleda) {
        this.nazivKlinike = nazivKlinike;
        this.ocenaKlinike = ocena;
        this.adresaKlinike = adresaKlinike;
        this.cenaPregleda = cenaPregleda;
    }

    public String getNazivKlinike() {
        return nazivKlinike;
    }

    public void setNazivKlinike(String nazivKlinike) {
        this.nazivKlinike = nazivKlinike;
    }

    public double getOcena() {
        return ocenaKlinike;
    }

    public void setOcena(double ocena) {
        this.ocenaKlinike = ocena;
    }

    public String getAdresaKlinike() {
        return adresaKlinike;
    }

    public void setAdresaKlinike(String adresaKlinike) {
        this.adresaKlinike = adresaKlinike;
    }

    public double getCenaPregleda() {
        return cenaPregleda;
    }

    public void setCenaPregleda(double cenaPregleda) {
        this.cenaPregleda = cenaPregleda;
    }
}
