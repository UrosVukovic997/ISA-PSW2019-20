package com.example.ClinicalCenter.controller;


import com.example.ClinicalCenter.dto.KlinikaDTO;
import com.example.ClinicalCenter.model.Klinika;
import com.example.ClinicalCenter.service.KlinikaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/klinika")
public class KlinikaController {

    @Autowired
    private KlinikaService klinikaService;


    @PostMapping(path = "/dodaj", consumes = "application/json")
    public ResponseEntity<Void> addKlinika(@RequestBody KlinikaDTO klinikaDTO) {

        Klinika klinika = new Klinika(klinikaDTO.getNazivKlinike(), klinikaDTO.getGrad());
        Klinika k=klinikaService.add(klinika);
        if(k == null){
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
        return new ResponseEntity<>((HttpStatus.CREATED));

    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<KlinikaDTO>> getAll(){
        List<Klinika> klinike=klinikaService.findAll();
        List<KlinikaDTO> klinikeDTOS= new ArrayList<>();
        for (Klinika k: klinike) {
            klinikeDTOS.add(new KlinikaDTO(k));
        }
        return new ResponseEntity<>(klinikeDTOS,HttpStatus.OK);
    }

    @GetMapping(path = "/getAllNames")
    public ResponseEntity<List<String>> getAllNames(){
        List<String> klinike=klinikaService.findAllNames();
        return new ResponseEntity<>(klinike,HttpStatus.OK);
    }

    @GetMapping(path = "/findByName/{naziv}")

    public ResponseEntity<Klinika> getByName(@PathVariable String naziv){
        Klinika klinika=klinikaService.findByNazivKlinike(naziv);
        return new ResponseEntity<Klinika>(klinika, HttpStatus.OK);
    }

    @DeleteMapping(value = "/obrisi{id}")
    public ResponseEntity<Void> deleteKlinika(@PathVariable Long id) {
        klinikaService.deleteById(id);
        return new ResponseEntity<>((HttpStatus.OK));

    }
}
