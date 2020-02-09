package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.model.*;
import com.example.ClinicalCenter.repository.PacijentRepository;
import com.example.ClinicalCenter.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> findAll() {
        return salaRepository.findAll();
    }

    public Sala findById(long id) {
        return salaRepository.findById(id);
    }

}

