package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.repository.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminService {
    @Autowired
    private TerminRepository pacijentRepository;
}
