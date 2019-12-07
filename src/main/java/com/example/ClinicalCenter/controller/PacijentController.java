package com.example.ClinicalCenter.controller;


import com.example.ClinicalCenter.dto.PacijentDTO;
import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.service.PacijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/pacijenti")
public class PacijentController {

    @Autowired
    private PacijentService pacijentService;

    @GetMapping(value = "/zahtev", produces= MediaType.APPLICATION_JSON_VALUE)
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

    @PostMapping(path = "/registruj", consumes = "application/json")
    public ResponseEntity<Void> signUp(@RequestBody PacijentDTO pacijentDTO)  {
        System.out.println("USLO");

        Pacijent p = pacijentService.findOneByEMail(pacijentDTO.getEmail());
        if (p != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        System.out.println("USLO1");

        Pacijent pacijent = new Pacijent();
        pacijent.setImePacijenta(pacijentDTO.getImePacijenta());
        pacijent.setPrezimePacijenta(pacijentDTO.getPrezimePacijenta());
        pacijent.setEmail(pacijentDTO.getEmail());
        pacijent.setLozinka(pacijentDTO.getLozinka());
        pacijent.setAdresa(pacijentDTO.getAdresa());
        pacijent.setGrad(pacijentDTO.getGrad());
        pacijent.setDrzava(pacijentDTO.getDrzava());
        pacijent.setBrojTelefona(pacijentDTO.getBrojTelefona());
        pacijent.setJbo(pacijentDTO.getJbo());
        pacijent.setOdobren(false);
        pacijent.setPotvrdio(false);
        System.out.println("USLO2");


        pacijent = pacijentService.save(pacijent);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }



}
