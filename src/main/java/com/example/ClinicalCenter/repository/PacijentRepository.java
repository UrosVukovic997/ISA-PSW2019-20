package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.Pacijent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacijentRepository extends JpaRepository<Pacijent, Long> {



    @Query("select p from Pacijent p where p.Odobren = false")
    List<Pacijent> pronadjiNeOdobrene();

    Optional<Pacijent> findById(Long id);

    List<Pacijent> findAll();
    void removeById(Long id);
    Pacijent save(Pacijent pacijent);

    Pacijent findByEmail(String eMail);
}
