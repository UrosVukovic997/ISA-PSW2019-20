package com.example.ClinicalCenter.integrationNikola;

import com.example.ClinicalCenter.constants.AdminKcConstants;
import com.example.ClinicalCenter.constants.KlinikaConstants;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasItem;

import javax.annotation.PostConstruct;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdminKcControllerTest {


    @Autowired
    private TestRestTemplate testRestTemplate;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    private MediaType contentType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype());

    @PostConstruct
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void testGetBezKartona() throws Exception {

        this.mockMvc.perform(get(AdminKcConstants.URL_PREFIX + AdminKcConstants.GET_BEZ_KARTONA_URL)
                .contentType(contentType))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(AdminKcConstants.BROJ_PACIJENATA)))
                .andExpect(jsonPath("$.[*].imePacijenta").
                        value(hasItem(AdminKcConstants.NAZIV_PACIJENTA)));


    }

}
