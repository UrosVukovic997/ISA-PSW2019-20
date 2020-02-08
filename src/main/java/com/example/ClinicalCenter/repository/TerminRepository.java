package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.model.Termin;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface TerminRepository extends JpaRepository<Termin, Long> {

    Termin save(Termin termin);
}
