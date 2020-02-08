package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.model.Izvestaj;
import com.example.ClinicalCenter.repository.IzvestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IzvestajService {

    @Autowired
    private IzvestajRepository izvestajRepository;

    public Izvestaj save(Izvestaj i){ return  izvestajRepository.save(i);}
}
