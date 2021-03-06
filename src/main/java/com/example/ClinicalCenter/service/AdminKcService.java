package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.model.AdminKC;
import com.example.ClinicalCenter.repository.AdminKcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminKcService {

    @Autowired
    private AdminKcRepository adminKcRepository;

    public AdminKC save(AdminKC adminKC){return adminKcRepository.save(adminKC);}

    public int prvoPrijavljivanje( Long id){return adminKcRepository.prvoPrijavljivanje(id);}

    public int updateAdmin(Long id, String ime, String prezime, String email){return adminKcRepository.updateAdmin(id,ime,prezime,email);}

    public AdminKC getByUsername(String username){return adminKcRepository.getAdminKCByUsername(username);}
    public AdminKC getByEmail(String email){return adminKcRepository.getAdminKCByEmail(email);}
    public List<AdminKC> getAll() {return adminKcRepository.findAll();}
    public void delete(Long id) {adminKcRepository.deleteById(id);}
}
