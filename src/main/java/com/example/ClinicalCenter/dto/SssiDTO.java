package com.example.ClinicalCenter.dto;

public class SssiDTO {

    String string1;
    String string2;
    String string3;
    Integer integer;

    public SssiDTO() {
    }

    public SssiDTO(String string1, String string2, String string3, Integer integer) {
        this.string1 = string1;
        this.string2 = string2;
        this.string3 = string3;
        this.integer = integer;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public String getString3() {
        return string3;
    }

    public void setString3(String string3) {
        this.string3 = string3;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}
