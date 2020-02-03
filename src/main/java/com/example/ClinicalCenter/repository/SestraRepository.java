package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.Sestra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SestraRepository extends JpaRepository<Sestra, Long> {

    Sestra findByUsername(String username);
}
