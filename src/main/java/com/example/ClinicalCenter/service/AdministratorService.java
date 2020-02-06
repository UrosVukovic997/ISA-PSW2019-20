package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.model.Administrator;
import com.example.ClinicalCenter.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public List<Administrator> findAll(){ return  administratorRepository.findAll();}

    public List<Administrator> findAllByKlinika(String klinika){ return  administratorRepository.findAllByKlinika(klinika);}

    public Administrator add(Administrator administrator){return administratorRepository.save(administrator);}

    public void deleteById(Long id){administratorRepository.deleteById(id);}

    public Administrator findByUsername(String Username) {
        return administratorRepository.findByUsername(Username);
    }
    public Administrator FindByEmail(String email) {
        return administratorRepository.findByEmail(email);
    }
}
