package com.example.ClinicalCenter.Service;

import com.example.ClinicalCenter.model.Klinika;
import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.repository.KlinikaRepository;
import com.example.ClinicalCenter.repository.PacijentRepository;
import com.example.ClinicalCenter.service.PacijentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PacijentServiceTest {

    @Autowired
    private PacijentService pacijentService;

    @Autowired
    private PacijentRepository pacijentRepository;

    @BeforeEach
    public void setup()  {

    }


    @Test
    @Rollback
    void findOnyById() {
        Pacijent p = pacijentService.findOne(1L);
        assertNotNull(p);

        assertEquals(p.getImePacijenta(), "Marko");
        assertEquals(p.getPrezimePacijenta(), "Markovic");
        assertEquals(p.getId(), 1L);
        assertEquals(p.getOdobren(), true);
    }

    @Test
    @Rollback
    void findAll() {
        List<Pacijent> p = pacijentService.findAll();
        assertNotNull(p);

        assertEquals(p.size(), 3);
    }


    @Test
    @Rollback
    void findByUsername() {
        Pacijent p = pacijentService.findByUsername("pacijent");
        assertNotNull(p);

        assertEquals(p.getUsername(), "pacijent");
        assertEquals(p.getGrad(), "Novi Sad");
    }
}
