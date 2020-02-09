package com.example.ClinicalCenter.dto;

public class IdStringDTO {

    Long id;
    String string1;

    public IdStringDTO() {
    }

    public IdStringDTO(Long id, String string) {
        this.id = id;
        this.string1 = string;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string) {
        this.string1 = string;
    }
}
