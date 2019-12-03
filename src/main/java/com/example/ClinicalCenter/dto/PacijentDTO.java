package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Pacijent;

public class PacijentDTO {

    private Long Id;
    private String ImePacijenta;
    private String PrezimePacijenta;
    private String email;
    private String Lozinka;
    private String Adresa;
    private String Grad;
    private String Drzava;
    private String BrojTelefona;
    private int JBO;

    public PacijentDTO() {
    }

    public PacijentDTO(Pacijent pacijent) {
        this(pacijent.getId(), pacijent.getImePacijenta(), pacijent.getPrezimePacijenta(), pacijent.getemail(), pacijent.getLozinka(), pacijent.getAdresa(), pacijent.getGrad(), pacijent.getGrad(), pacijent.getBrojTelefona(), pacijent.getJBO() );
    }

    public PacijentDTO(Long id, String imePacijenta, String prezimePacijenta, String e_mail, String lozika , String Adresa, String Grad, String Drzava, String Brtl, int JBO) {
        this.Id = id;
        this.ImePacijenta = imePacijenta;
        this.PrezimePacijenta = prezimePacijenta;
        this.email = e_mail;
        this.Lozinka = lozika;
        this.Adresa = Adresa;
        this.Grad = Grad;
        this.Drzava= Drzava;
        this.BrojTelefona = Brtl;
        this.JBO = JBO;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
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

    public String getemail() {
        return email;
    }

    public void setemail(String E_mail) {
        email = E_mail;
    }

    public int getJBO() {
        return JBO;
    }

    public void setJBO(int JBO) {
        this.JBO = JBO;
    }

    public String getLozinka() {
        return Lozinka;
    }

    public void setLozinka(String lozinka) {
        Lozinka = lozinka;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public String getGrad() {
        return Grad;
    }

    public void setGrad(String grad) {
        Grad = grad;
    }

    public String getDrzava() {
        return Drzava;
    }

    public void setDrzava(String drzava) {
        Drzava = drzava;
    }

    public String getBrojTelefona() {
        return BrojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        BrojTelefona = brojTelefona;
    }



}
