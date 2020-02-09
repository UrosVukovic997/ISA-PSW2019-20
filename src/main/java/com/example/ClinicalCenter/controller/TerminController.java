package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.repository.SalaRepository;
import com.example.ClinicalCenter.repository.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/termin")
public class TerminController {

    @Autowired
    private TerminRepository terminRepository;


}
