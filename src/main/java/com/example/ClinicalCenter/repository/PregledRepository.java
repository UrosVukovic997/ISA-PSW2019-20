package com.example.ClinicalCenter.repository;


import com.example.ClinicalCenter.model.Pregled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PregledRepository extends JpaRepository<Pregled,Long> {

    @Override
    List<Pregled> findAll();

    Pregled save(Pregled pregled);

    @Override
    void deleteById(Long id);

    List<Pregled> findByJbo(int jbo);


}
