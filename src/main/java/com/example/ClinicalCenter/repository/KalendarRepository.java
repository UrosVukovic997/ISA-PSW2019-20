package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.Kalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KalendarRepository extends JpaRepository<Kalendar, Long> {

    Kalendar save(Kalendar kalendar);

}
