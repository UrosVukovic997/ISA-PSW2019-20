package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.repository.PacijentRepository;
import com.example.ClinicalCenter.repository.RegistracijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistracijaService {

    @Autowired
    private RegistracijaRepository registracijaRepository;
    @Autowired
    private PacijentRepository pacijentRepository;


    public Pacijent odobriKorsnika(Long id) {
        if(registracijaRepository.odobriKorisnika(id) !=0){
            return pacijentRepository.findById(id).orElseGet(null);
        }
        else{
            return  null;
        }
    }

    public Pacijent potvrdiKorisnika(Long id){
        if(registracijaRepository.potvrdiKorisnika(id) !=0){
            return pacijentRepository.findById(id).orElseGet(null);
        }
        else
            return  null;
    }
    public void obrisiKorisnika(Long id) {registracijaRepository.odrisiKorisnika(id);}
}
