package com.example.ClinicalCenter.controllerNikola;

import com.example.ClinicalCenter.constants.KlinikaConstants;
import com.example.ClinicalCenter.constants.LekarConstants;
import com.example.ClinicalCenter.dto.LekarDTO;
import com.example.ClinicalCenter.dto.PregledDTO;
import com.example.ClinicalCenter.model.Klinika;
import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.service.KlinikaService;
import com.example.ClinicalCenter.service.LekarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import javax.annotation.PostConstruct;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LekarControllerTest<ExaminationService, PatientService> {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private MockMvc mockMvc;

    @MockBean
    private LekarService lekarServiceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;


    ArrayList<Lekar> lekari = new ArrayList<>();

    LekarDTO lekar;

    private MediaType contentType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype());

    @PostConstruct
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();


        lekar = new LekarDTO();

        lekar.setId(LekarConstants.ID_LEKARA);
        lekar.setKorIme(LekarConstants.USERNAME_LEKARA1);

        lekar.setAdresa(LekarConstants.ADRESA_LEKARA);
        lekar.setEmail(LekarConstants.EMAIL_LEKARA);
        lekar.setIme(LekarConstants.NAME_LEKARA);
        lekar.setLozinka(LekarConstants.PASSWORD_LEKARA);
        lekar.setPrezime(LekarConstants.LAST_NAME_LEKARA);
        lekar.setSpecijalnost(LekarConstants.SPEC_LEKARA);
        lekar.setOpis(LekarConstants.DESCRIPTION_LEKARA);
        HashSet<Pacijent> pacijenti = new HashSet<>();
        Pacijent pacijent = new Pacijent();
        pacijent.setId(1l);
        pacijenti.add(pacijent);
        lekar.setPacijenti(pacijenti);

    }

    @Test
    public void testGetAllPacijenti() throws Exception {

        this.mockMvc.perform(get(LekarConstants.URL_PREFIX + "/pacijenti/getAll")
                .contentType(contentType))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andDo(print())
                .andExpect(jsonPath("$.*", hasSize(LekarConstants.BROJ_LEKARA)));
    }

    @Test
    public void testIzmeniLekara() throws Exception {

        String json = new ObjectMapper().writeValueAsString(lekar);

        mockMvc.perform(post("/api/lekar/izmeniProfil")
                .contentType(contentType)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));

    }

}
