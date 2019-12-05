package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.Lek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LekRepository extends JpaRepository<Lek,Long> {

    @Override
    List<Lek> findAll();

    Lek save(Lek lek);

    @Override
    void deleteById(Long id);


}
