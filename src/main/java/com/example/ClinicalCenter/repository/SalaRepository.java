package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.Administrator;
import com.example.ClinicalCenter.model.Sala;
import com.example.ClinicalCenter.model.Termin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

    List<Sala> findAll();

    //List<Sala> findAllByTermin( Termin termin);

    Sala save(Sala sala);

    Sala findById(long id);
    //Administrator findByNaziv(String naziv);
   // Administrator findByBroj(int broj);

}
