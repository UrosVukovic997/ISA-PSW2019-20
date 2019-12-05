package com.example.ClinicalCenter.dto;

import com.example.ClinicalCenter.model.Dijagnoza;
import com.example.ClinicalCenter.model.Karton;
import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.model.Pregled;

import java.util.Set;

public class KartonDTO {

    private long id;
    private Integer broj;    /*zbog baze*/
    private Set<Dijagnoza> dijagnoze;
    private Set<Pregled> pregledi;
    private Pacijent pacijent;


    public KartonDTO() {
    }

    public KartonDTO(Karton karton){
        this(karton.getId(),karton.getBroj(),karton.getDijagnoze(),karton.getPregledi(),karton.getPacijent());
    }

    public KartonDTO(long id, Integer broj, Set<Dijagnoza> dijagnoze, Set<Pregled> pregledi, Pacijent pacijent) {
        this.id = id;
        this.broj = broj;
        this.dijagnoze = dijagnoze;
        this.pregledi = pregledi;
        this.pacijent = pacijent;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getBroj() {
        return broj;
    }

    public void setBroj(Integer broj) {
        this.broj = broj;
    }

    public Set<Dijagnoza> getDijagnoze() {
        return dijagnoze;
    }

    public void setDijagnoze(Set<Dijagnoza> dijagnoze) {
        this.dijagnoze = dijagnoze;
    }

    public Set<Pregled> getPregledi() {
        return pregledi;
    }

    public void setPregledi(Set<Pregled> pregledi) {
        this.pregledi = pregledi;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }


}
