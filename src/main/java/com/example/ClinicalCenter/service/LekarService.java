package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.repository.LekarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public class LekarService {

    @Autowired
    private LekarRepository lekarRepository;


    public List<Lekar> findAll() {
        return lekarRepository.findAll();
    }

    public Lekar findOne(Long id) {
        return lekarRepository.findById(id).orElseGet(null);
    }
}
