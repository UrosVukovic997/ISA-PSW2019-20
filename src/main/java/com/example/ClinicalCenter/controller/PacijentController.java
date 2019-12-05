package com.example.ClinicalCenter.controller;


import com.example.ClinicalCenter.dto.PacijentDTO;
import com.example.ClinicalCenter.model.Karton;
import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.service.PacijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/pacijenti")
public class PacijentController {

    @Autowired
    private PacijentService pacijentService;

    @GetMapping(value = "/zahtev")
    public ResponseEntity<List<PacijentDTO>> pronadjiNeOdobrene() {
       List<Pacijent> pacijenti = pacijentService.pronadjiNeOdobrene();
       List<PacijentDTO> PacijentiDTO = new ArrayList<>();
       for(Pacijent p : pacijenti){
           PacijentiDTO.add(new PacijentDTO(p));
       }
       return new ResponseEntity<>(PacijentiDTO, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PacijentDTO> getPacijent(@PathVariable Long id) {

        Pacijent pacijent = pacijentService.findOne(id);

        if (pacijent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new PacijentDTO(pacijent), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PacijentDTO>> getPacijentPage(Pageable page) {

        // page object holds data about pagination and sorting
        // the object is created based on the url parameters "page", "size" and "sort"
        Page<Pacijent> pacijenti = pacijentService.findAll(page);

        // convert students to DTOs
        List<PacijentDTO> pacijentiDTO = new ArrayList<>();
        for (Pacijent p : pacijenti) {
            pacijentiDTO.add(new PacijentDTO(p));
        }

        return new ResponseEntity<>(pacijentiDTO, HttpStatus.OK);
    }


}
