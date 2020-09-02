package com.example.ClinicalCenter.repositoryNikola;

import com.example.ClinicalCenter.constants.AdminKcConstants;
import com.example.ClinicalCenter.model.AdminKC;
import com.example.ClinicalCenter.model.Klinika;
import com.example.ClinicalCenter.repository.AdminKcRepository;
import com.example.ClinicalCenter.repository.KlinikaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdminKcRepositoryTest {

    @Autowired
    private AdminKcRepository adminKcRepository;

    @Test
    public void TestUpdatePassword() {
        int result = adminKcRepository.updatePassword( AdminKcConstants.ID_ADMINKC,"password");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void TestGetAdminKCByEmail() {
        AdminKC adminKC = adminKcRepository.getAdminKCByEmail("perakc@uns.ac.rs");
        assertThat(adminKC.getId()).isEqualTo( AdminKcConstants.ID_ADMINKC );
    }


}
