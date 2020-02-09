package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.model.Sala;
import com.example.ClinicalCenter.repository.PacijentRepository;
import com.example.ClinicalCenter.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/sala")
public class SalaController {

    @Autowired
    private SalaRepository salaRepository;


}
