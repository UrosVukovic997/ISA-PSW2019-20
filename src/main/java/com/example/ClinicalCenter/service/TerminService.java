package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.model.Termin;
import com.example.ClinicalCenter.repository.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminService {
    @Autowired
    private TerminRepository terminRepository;

    public Termin save(Termin termin) {
        return terminRepository.save(termin);
    }
}
