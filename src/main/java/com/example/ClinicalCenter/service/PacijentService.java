package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.repository.PacijentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacijentService {

    @Autowired
    private PacijentRepository pacijentRepository;


    public List<Pacijent> pronadjiNeOdobrene() {
        return pacijentRepository.findAllByOdobrenFalse();
    }


    public Pacijent findOne(Long id) {
        return pacijentRepository.findById(id).orElseGet(null);
    }

    public Pacijent findOneByE_Mail(String email) {
        return pacijentRepository.findByEmail(email);
    }

    public List<Pacijent> findAll() {
        return pacijentRepository.findAll();
    }

    public Page<Pacijent> findAll(Pageable page) {
        return pacijentRepository.findAll(page);
    }

    public Pacijent save(Pacijent student) {
        return pacijentRepository.save(student);
    }



    public void remove(Long id) {
        pacijentRepository.deleteById(id);
    }

    public Pacijent findOneByEMail(String geteMail) {
        return pacijentRepository.findByEmail(geteMail);
    }
}
