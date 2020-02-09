package com.example.ClinicalCenter.Service;

import com.example.ClinicalCenter.model.Klinika;
import com.example.ClinicalCenter.repository.KlinikaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KlinikaServiceUnitTest {

    @MockBean
    private KlinikaRepository klinikaRepository;

    @BeforeEach
    public void setup() {

        Klinika klinika = new Klinika();
        klinika.setOcena(3.7);
        klinika.setNazivKlinike("Bolnica");
        klinika.setGrad("Atenica 35 Cacak");
        klinika.setId(1L);
        when(
                klinikaRepository.save(any(Klinika.class))
        ).thenReturn(
                klinika
        );

    }


    @Test
    public void addClinicTest() throws Exception {

        Klinika klinika = new Klinika();
        klinika.setNazivKlinike("Bolnica");
        klinika.setGrad("Atenica 35 Cacak");
        klinika.setOcena(3.7);

        Klinika k = klinikaRepository.save(klinika);

        assertEquals(1L, k.getId());

    }

    @Test
    public void getKlinikeTest() {
        Klinika klinika = new Klinika();
        klinika.setId(1L);
        klinika.setNazivKlinike("Bolnica");
        klinika.setGrad("Atenica 35 Cacak");
        klinika.setOcena(3.7);

        Mockito.when(klinikaRepository.findByNazivKlinike("Bolnica")).thenReturn(klinika);

        Klinika result = klinikaRepository.findByNazivKlinike("Bolnica");

        assertNotNull(result);
        assertEquals(result.getId(), klinika.getId());
        assertEquals(result.getOcena(), klinika.getOcena());
    }

}
