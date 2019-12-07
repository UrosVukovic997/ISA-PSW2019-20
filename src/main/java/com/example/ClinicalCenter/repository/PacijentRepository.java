package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.service.PacijentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacijentRepository extends JpaRepository<Pacijent, Long> {


    List<Pacijent> findAllByOdobrenFalse();

   // Pacijent findByEmail(String Email);

    Optional<Pacijent> findById(Long id);

    List<Pacijent> findAll();
    void removeById(Long id);
    Pacijent save(Pacijent pacijent);

    Pacijent findByEmail(String eMail);

}
