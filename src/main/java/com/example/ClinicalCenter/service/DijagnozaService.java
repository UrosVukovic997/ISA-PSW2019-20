package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.model.Dijagnoza;
import com.example.ClinicalCenter.repository.DijagnozaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DijagnozaService {

    @Autowired
    private DijagnozaRepository dijagnozaRepository;

    public List<Dijagnoza> findAll(){ return  dijagnozaRepository.findAll();}

    public Dijagnoza add(Dijagnoza dijagnoza){return dijagnozaRepository.save(dijagnoza);}

    public void deleteById(Long id){dijagnozaRepository.deleteById(id);}


}
