package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.Recept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptRepository extends JpaRepository<Recept, Long> {

    List<Recept> findByKlinika(String klinika);
    Recept save(Recept recept);
}
