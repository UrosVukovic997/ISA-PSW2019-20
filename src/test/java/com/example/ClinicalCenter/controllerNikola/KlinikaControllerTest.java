package com.example.ClinicalCenter.controllerNikola;

import com.example.ClinicalCenter.constants.KlinikaConstants;
import com.example.ClinicalCenter.dto.KlinikaDTO;
import com.example.ClinicalCenter.model.Klinika;
import com.example.ClinicalCenter.service.KlinikaService;
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

import javax.annotation.PostConstruct;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KlinikaControllerTest<ExaminationService, PatientService> {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private MockMvc mockMvc;

    @MockBean
    private KlinikaService klinikaServiceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;

    Klinika klinika;


    private MediaType contentType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype());

    private MediaType contentTypePost = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @PostConstruct
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();

        klinika = new Klinika();
        klinika.setNazivKlinike(KlinikaConstants.NAZIV_KLINIKE);
        klinika.setId(KlinikaConstants.ID_KLINIKE);
    }


   @Test
    public void testGetByName() throws Exception {
        Mockito.when(klinikaServiceMock.findByNazivKlinike(Mockito.any(String.class))).thenReturn(klinika);

        MvcResult result = this.mockMvc.perform(get(KlinikaConstants.URL_PREFIX + KlinikaConstants.FIND_BY_NAME_URL)
               .contentType(contentType))
               .andExpect(status().isOk())
               .andExpect(content().contentType(contentType))
               .andDo(print())
               .andReturn();

       String json = result.getResponse().getContentAsString();

       Klinika resultKlinika = new ObjectMapper().readValue(json, Klinika.class);
       assertEquals(klinika.getNazivKlinike(), resultKlinika.getNazivKlinike());
       assertEquals(klinika.getId(), resultKlinika.getId());

   }

    @Test
    public void testAddClinic() throws Exception {

        KlinikaDTO klinikaDTO = new KlinikaDTO();

        klinikaDTO.setNazivKlinike("KCV");
        klinikaDTO.setGrad("Novi Sad");
        klinikaDTO.setOcena(6);

        String json = new ObjectMapper().writeValueAsString(klinikaDTO);

        this.mockMvc.perform(post(KlinikaConstants.URL_PREFIX + KlinikaConstants.ADD_CLINIC_URL)
                .contentType(contentTypePost)
                .content(json))
                .andDo(print())
                .andExpect(status().isCreated());

    }

    /*@Test
    void getAlltest() {
        ResponseEntity<List> responseEntity =
                testRestTemplate.getForEntity("/api/klinika/getAll", List.class);

        List<Klinika> tmp = responseEntity.getBody();
        assertEquals(tmp.size(), 2);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }*/

}
