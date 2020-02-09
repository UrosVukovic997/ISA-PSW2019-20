package com.example.ClinicalCenter.repository;


import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.model.Termin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TerminRepository extends JpaRepository<Termin, Long> {

    Termin save(Termin termin);
    List<Termin> findAll();
    List<Termin> findAllById(long id);

}
