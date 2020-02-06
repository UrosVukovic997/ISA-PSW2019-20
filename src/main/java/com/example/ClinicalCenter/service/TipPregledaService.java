package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.model.TipPregleda;
import com.example.ClinicalCenter.repository.TipPregledaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipPregledaService {

    @Autowired
    private TipPregledaRepository tipPregledaRepository;

    public List<TipPregleda> findAll() {
        return tipPregledaRepository.findAll();
    }

}
