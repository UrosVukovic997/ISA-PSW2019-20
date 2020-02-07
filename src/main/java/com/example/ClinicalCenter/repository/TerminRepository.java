package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.model.Termin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerminRepository extends JpaRepository<Lekar, Long> {

    Termin save(Termin termin);
}
