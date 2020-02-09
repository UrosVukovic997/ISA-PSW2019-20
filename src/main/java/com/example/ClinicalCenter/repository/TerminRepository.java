package com.example.ClinicalCenter.repository;


import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.model.Termin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TerminRepository extends JpaRepository<Termin, Long> {

    List<Termin> findAllById(long id);
    List<Termin> findAll();
    Termin save(Termin termin);
    Termin findById(long id);

}
