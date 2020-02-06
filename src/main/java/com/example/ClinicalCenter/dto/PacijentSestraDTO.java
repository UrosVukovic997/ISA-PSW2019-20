package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Pacijent;

public class PacijentSestraDTO {

    private Long id;
    private String imePacijenta;
    private String prezimePacijenta;
    private String email;
    private Integer jbo;


    public PacijentSestraDTO(Long id, String imePacijenta, String prezimePacijenta, String email, Integer jbo) {
        this.id = id;
        this.imePacijenta = imePacijenta;
        this.prezimePacijenta = prezimePacijenta;
        this.email = email;
        this.jbo = jbo;
    }

    public PacijentSestraDTO(Pacijent p) {
        this.id = p.getId();
        this.imePacijenta = p.getImePacijenta();
        this.prezimePacijenta = p.getPrezimePacijenta();
        this.email = p.getEmail();
        this.jbo = p.getJbo();
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

    public Integer getJbo() {
        return jbo;
    }

    public void setJbo(Integer jbo) {
        this.jbo = jbo;
    }
}
