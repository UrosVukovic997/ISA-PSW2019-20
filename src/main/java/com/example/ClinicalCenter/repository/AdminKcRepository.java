package com.example.ClinicalCenter.repository;

import com.example.ClinicalCenter.model.AdminKC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AdminKcRepository extends JpaRepository<AdminKC, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE AdminKC a SET a.prvoPrijavljivanje = false WHERE a.id =:id")
    int prvoPrijavljivanje(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE AdminKC a SET a.lozinka = :password WHERE a.id =:id")
    int updatePassword(Long id, String password);

    @Transactional
    @Modifying
    @Query("UPDATE AdminKC a SET a.ime = :ime, a.prezime = :prezime, a.email = :email WHERE a.id =:id")
    int updateAdmin(Long id, String ime, String prezime, String email);

    AdminKC save(AdminKC adminKC);

    AdminKC getAdminKCByUsername(String username);

}
