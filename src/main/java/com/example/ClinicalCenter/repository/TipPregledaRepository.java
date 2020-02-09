package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.OdsustvoOdmor;
import com.example.ClinicalCenter.model.Pregled;
import com.example.ClinicalCenter.model.TipPregleda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipPregledaRepository extends JpaRepository<TipPregleda, Long> {
    @Override
    List<TipPregleda> findAll();

    TipPregleda save(TipPregleda tipPregleda);

    @Override
    void deleteById(Long id);

    TipPregleda findByNaziv(String naziv);


}