package com.example.ClinicalCenter.serviceNikola;

import com.example.ClinicalCenter.constants.LekarConstants;
import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.service.LekarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class LekarServiceTest {

    @Autowired
    LekarService lekarService;

    @Test
    public void findOne(){
        Lekar lekar = lekarService.findOne(LekarConstants.ID_LEKARA);
        assertThat(lekar).isNotNull();

        assertThat(lekar.getAdresa()).isEqualTo(LekarConstants.ADRESA_LEKARA);
        assertThat(lekar.getEmail()).isEqualTo(LekarConstants.EMAIL_LEKARA);
        assertThat(lekar.getIme()).isEqualTo(LekarConstants.NAME_LEKARA);
        assertThat(lekar.getKorIme()).isEqualTo(LekarConstants.USERNAME_LEKARA);
        assertThat(lekar.getLozinka()).isEqualTo(LekarConstants.PASSWORD_LEKARA);
        assertThat(lekar.getOpis()).isEqualTo(LekarConstants.DESCRIPTION_LEKARA);
        assertThat(lekar.getPrezime()).isEqualTo(LekarConstants.LAST_NAME_LEKARA);
        assertThat(lekar.getProsecna_ocena()).isEqualTo(LekarConstants.AVERAGE_RATE_LEKARA);
        assertThat(lekar.getSpecijalnost()).isEqualTo(LekarConstants.SPEC_LEKARA);

    }

}
