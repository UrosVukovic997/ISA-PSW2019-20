package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.service.RegistracijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/registracija")
public class RegistracijaController {

    @Autowired
    private RegistracijaService registracijaService;

    @PostMapping (value = "/odobri{id}")
    public ResponseEntity<Void> odobriStudenta(@PathVariable Long id){
        registracijaService.odobriKorsnika(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping (value = "/obrisi{id}")
    public ResponseEntity<Void> obrisiStudenta(@PathVariable Long id){
        registracijaService.obrisiKorisnika(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
