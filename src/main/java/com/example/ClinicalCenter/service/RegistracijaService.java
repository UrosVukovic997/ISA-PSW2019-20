package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.repository.RegistracijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistracijaService {

    @Autowired
    private RegistracijaRepository registracijaRepository;

    public void odobriKorsnika(Long id) {registracijaRepository.odobriKorisnika(id);}
    public void obrisiKorisnika(Long id) {registracijaRepository.odrisiKorisnika(id);}
}
