package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.model.Recept;
import com.example.ClinicalCenter.repository.ReceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceptService {

    @Autowired
    private ReceptRepository receptRepository;

    public List<Recept> findByKlinika(String klinika) {return receptRepository.findByKlinika(klinika);}
    public Recept save(Recept recept) {return  receptRepository.save(recept);}
    public Recept findById(Long id) {return  receptRepository.findById(id).orElseGet(null );}
}
