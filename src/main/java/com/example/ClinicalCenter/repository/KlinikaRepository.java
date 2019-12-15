package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.Klinika;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface KlinikaRepository extends JpaRepository<Klinika, Long> {

    List<Klinika> findAll();

    Klinika save(Klinika klinika);

    void deleteById(Long id);
    void deleteKlinikaById(Long id);

}
