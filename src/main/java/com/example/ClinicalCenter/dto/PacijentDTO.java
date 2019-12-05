package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Pacijent;

public class PacijentDTO {

    private Long id;
    private String ImePacijenta;
    private String PrezimePacijenta;
    private String Email;
    private int JBO;

    public PacijentDTO() {
    }

    public PacijentDTO(Pacijent pacijent) {
        this(pacijent.getId(), pacijent.getImePacijenta(), pacijent.getPrezimePacijenta(), pacijent.getEmail(), pacijent.getJbo() );
    }

    public PacijentDTO(Long id, String imePacijenta, String prezimePacijenta, String email, int JBO) {
        this.id = id;
        ImePacijenta = imePacijenta;
        PrezimePacijenta = prezimePacijenta;
        Email = email;
        this.JBO = JBO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImePacijenta() {
        return ImePacijenta;
    }

    public void setImePacijenta(String imePacijenta) {
        ImePacijenta = imePacijenta;
    }

    public String getPrezimePacijenta() {
        return PrezimePacijenta;
    }

    public void setPrezimePacijenta(String prezimePacijenta) {
        PrezimePacijenta = prezimePacijenta;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getJBO() {
        return JBO;
    }

    public void setJBO(int JBO) {
        this.JBO = JBO;
    }
}
