package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.Karton;
import com.example.ClinicalCenter.model.Pacijent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KartonRepository extends JpaRepository<Karton, Long> {

    Karton findByPacijent(Pacijent p);
    Karton findByBroj(Integer broj);

}

