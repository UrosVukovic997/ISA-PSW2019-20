package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.service.PacijentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacijentRepository extends JpaRepository<Pacijent, Long> {



    List<Pacijent> findAllByOdobrenFalse();

    @Query("select p from Pacijent p where p.odobren = false")
    List<Pacijent> pronadjiNeOdobrene();

    Pacijent findByEmail(String Email);


}
