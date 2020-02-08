package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.Izvestaj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IzvestajRepository extends JpaRepository<Izvestaj,Long> {

    Izvestaj save(Izvestaj izvestaj);
}
