package com.example.ClinicalCenter.dto;

public class UserDateDTO {
    String username;
    String date;

    public UserDateDTO() {
    }

    public UserDateDTO(String username, String date) {
        this.username = username;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
