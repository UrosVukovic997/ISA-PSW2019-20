package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.Dijagnoza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DijagnozaRepository extends JpaRepository<Dijagnoza, Long> {

    @Override
    List<Dijagnoza> findAll();

    Dijagnoza save(Dijagnoza dijagnoza);

    @Override
    void deleteById(Long id);
}
