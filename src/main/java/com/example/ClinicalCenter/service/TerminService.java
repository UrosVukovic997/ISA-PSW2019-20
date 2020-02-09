package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.model.Termin;
import com.example.ClinicalCenter.repository.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminService {
    @Autowired
    private TerminRepository terminRepository;

    public List<Termin> findAll() { return terminRepository.findAll(); }

    public List<Termin> findAllById(long id) { return terminRepository.findAllById(id); }

}
