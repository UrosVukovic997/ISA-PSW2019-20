package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.model.Kalendar;
import com.example.ClinicalCenter.repository.KalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KalendarService {

    @Autowired
    private KalendarRepository kalendarRepository;

    Kalendar save(Kalendar kalendar){return  kalendarRepository.save(kalendar);}
}
