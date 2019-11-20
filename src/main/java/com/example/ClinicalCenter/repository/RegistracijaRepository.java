package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.Pacijent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RegistracijaRepository extends JpaRepository<Pacijent, Long> {



    @Transactional
    @Modifying
    @Query("UPDATE Pacijent p SET p.Odobren = true WHERE p.id = id")
    void odobriKorisnika(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("DELETE from Pacijent p WHERE p.id = id")
    void odrisiKorisnika(@Param("id") Long id);

}
