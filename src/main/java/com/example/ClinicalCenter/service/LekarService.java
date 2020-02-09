package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.dto.LekarDTO;
import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.model.Termin;
import com.example.ClinicalCenter.repository.LekarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LekarService {

    @Autowired
    private LekarRepository lekarRepository;

    public List<Lekar> findAll() {
        return lekarRepository.findAll();
    }

    public Lekar save(LekarDTO noviLekar) {
        Lekar lekar = findOne(noviLekar.getId());

        lekar.setIme(noviLekar.getIme());
        lekar.setPrezime(noviLekar.getPrezime());
        lekar.setAdresa(noviLekar.getAdresa());
        lekar.setKorIme(noviLekar.getKorIme());
        lekar.setLozinka(noviLekar.getLozinka());
        lekar.setSpecijalnost(noviLekar.getSpecijalnost());
        lekar.setOpis(noviLekar.getOpis());

        return this.lekarRepository.save(lekar);
    }

    public Lekar findOne(Long id) {
        return lekarRepository.findById(id).orElseGet(null );
    }

    public void deleteById(Long id){ lekarRepository.deleteById(id); }

    public Lekar findByUsername(String Username) {
        return lekarRepository.findByKorIme(Username);
    }

    public Lekar findByEmail(String email) {
        return lekarRepository.findByEmail(email);
    }

    public Lekar findByKlinika(String email) {
        return lekarRepository.findByEmail(email);
    }

    public Lekar findByTermin(Termin t) { return lekarRepository.findByTermin(t);}
}
