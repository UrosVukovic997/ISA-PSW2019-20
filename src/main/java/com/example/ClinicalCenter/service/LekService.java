package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.model.Lek;
import com.example.ClinicalCenter.repository.LekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LekService {

    @Autowired
    private LekRepository lekRepository;

    public List<Lek> findAll(){return lekRepository.findAll();}

    public Lek add(Lek lek){return lekRepository.save(lek);}

    public void deleteById(Long id){ lekRepository.deleteById(id);}
}
