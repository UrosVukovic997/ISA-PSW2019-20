package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.dto.LekarPacDTO;
import com.example.ClinicalCenter.model.Klinika;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KlinikaControllerTest<ExaminationService, PatientService> {



    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void getAlltest() {
        ResponseEntity<List> responseEntity =
                testRestTemplate.getForEntity("/api/klinika/getAll", List.class);

        List<Klinika> tmp = responseEntity.getBody();
        assertEquals(tmp.size(), 2);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }



}
