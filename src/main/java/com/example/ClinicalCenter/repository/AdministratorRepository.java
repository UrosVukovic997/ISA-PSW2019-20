package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    List<Administrator> findAll();

    List<Administrator> findAllByKlinika( String klinika);

    Administrator save(Administrator administrator);

    void deleteById(Long id);

    Administrator findByUsername(String Username);
    Administrator findByEmail(String email);
}
