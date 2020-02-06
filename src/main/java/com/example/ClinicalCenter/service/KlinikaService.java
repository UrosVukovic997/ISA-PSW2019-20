package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.model.Klinika;
import com.example.ClinicalCenter.repository.KlinikaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KlinikaService {

    @Autowired
    private KlinikaRepository klinikaRepository;

    public List<Klinika> findAll(){ return  klinikaRepository.findAll();}

    public Klinika add(Klinika klinika){return klinikaRepository.save(klinika);}

    public void deleteById(Long id){klinikaRepository.deleteById(id);}

    public List<String> findAllNames(){
        List<Klinika> klinike=klinikaRepository.findAll();
        List<String> names = new ArrayList<>();
        for(Klinika k : klinike){
            names.add(k.getNazivKlinike());
        }
        return  names;
    }

    public Klinika findByNazivKlinike (String naziv){return klinikaRepository.findByNazivKlinike(naziv);}
}
