package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.repository.PacijentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacijentService {

    @Autowired
    private PacijentRepository pacijentRepository;


    public List<Pacijent> pronadjiNeOdobrene() {
        return pacijentRepository.pronadjiNeOdobrene();
    }
}
