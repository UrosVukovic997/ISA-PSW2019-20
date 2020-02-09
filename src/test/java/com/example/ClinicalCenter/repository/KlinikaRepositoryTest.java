package com.example.ClinicalCenter.repository;


import com.example.ClinicalCenter.model.Klinika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KlinikaRepositoryTest {

    @Autowired
    private KlinikaRepository klinikaRepository;

    @Test
    public void TestFindByNaziv() {
        Klinika klinika = klinikaRepository.findByNazivKlinike("KBC");
        assertThat(klinika.getId()).isEqualTo(2L);

    }


}
