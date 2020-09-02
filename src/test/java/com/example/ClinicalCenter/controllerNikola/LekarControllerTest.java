package com.example.ClinicalCenter.controllerNikola;

import com.example.ClinicalCenter.constants.KlinikaConstants;
import com.example.ClinicalCenter.model.Klinika;
import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.service.KlinikaService;
import com.example.ClinicalCenter.service.LekarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LekarControllerTest<ExaminationService, PatientService> {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private MockMvc mockMvc;

    @MockBean
    private LekarService lekarServiceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;

    Lekar lekar;


    private MediaType contentType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype());

    @PostConstruct
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();

        //lekar = new Klinika();
        //lekar.setNazivKlinike(KlinikaConstants.NAZIV_KLINIKE);
        lekar.setId(KlinikaConstants.ID_KLINIKE);
    }

}
