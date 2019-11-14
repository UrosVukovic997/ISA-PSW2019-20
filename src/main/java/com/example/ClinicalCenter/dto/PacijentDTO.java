package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Pacijent;

public class PacijentDTO {

    private Long id;
    private String ImePacijenta;
    private String PrezimePacijenta;
    private String E_mail;
    private int JBO;

    public PacijentDTO() {
    }

    public PacijentDTO(Pacijent pacijent) {
        this(pacijent.getId(), pacijent.getImePacijenta(), pacijent.getPrezimePacijenta(), pacijent.getE_mail(), pacijent.getJBO() );
    }

    public PacijentDTO(Long id, String imePacijenta, String prezimePacijenta, String e_mail, int JBO) {
        this.id = id;
        ImePacijenta = imePacijenta;
        PrezimePacijenta = prezimePacijenta;
        E_mail = e_mail;
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

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }

    public int getJBO() {
        return JBO;
    }

    public void setJBO(int JBO) {
        this.JBO = JBO;
    }
}
