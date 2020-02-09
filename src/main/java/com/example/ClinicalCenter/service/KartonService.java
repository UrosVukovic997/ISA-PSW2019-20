package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.model.Karton;
import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.repository.KartonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KartonService {

    @Autowired
    private KartonRepository kartonRepository;

    public Karton findOne(Long id) {
        return kartonRepository.findById(id).orElseGet(null);
    }

    public Karton findByPacijent(Pacijent pacijent) { return  kartonRepository.findByPacijent(pacijent);}

    public Karton save(Karton karton) {
        return kartonRepository.save(karton);
    }

    public void remove(Long id) {
        kartonRepository.deleteById(id);
    }

    public Karton findByBroj(Integer broj) {return kartonRepository.findByBroj(broj);}

}
