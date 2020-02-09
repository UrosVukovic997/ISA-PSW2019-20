package com.example.ClinicalCenter.Service;

import com.example.ClinicalCenter.model.Klinika;
import com.example.ClinicalCenter.repository.KlinikaRepository;
import com.example.ClinicalCenter.service.KlinikaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KlinikaServiceTest {

    @Autowired
    private KlinikaRepository klinikaRepository;

    @Autowired
    private KlinikaService klinikaService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findAll() {
        List<Klinika> clinics =  klinikaRepository.findAll();
        assertEquals(clinics.size(), 2);
    }

    @Test
    @Rollback
    @Transactional
    void createClinic() {
        Klinika k = new Klinika();
        k.setNazivKlinike("VMA");
        k.setGrad("Beograd");
        k.setOcena(5.5);

        Klinika klin = klinikaService.add(k);

        assertEquals(klin.getNazivKlinike(), k.getNazivKlinike());

        Klinika kl = klinikaService.findByNazivKlinike("VMA");

        assertNotNull(kl);
        assertEquals(kl.getId(), k.getId());

    }

}
