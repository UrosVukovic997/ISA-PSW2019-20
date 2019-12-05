package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.dto.DijagnozaDTO;
import com.example.ClinicalCenter.dto.LekDTO;
import com.example.ClinicalCenter.model.Dijagnoza;
import com.example.ClinicalCenter.model.Lek;
import com.example.ClinicalCenter.service.LekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/lek")
public class LekController {

    @Autowired
    private LekService lekService;

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<LekDTO>> getAll(){
        List<Lek> lekovi=lekService.findAll();
        List<LekDTO> lekDTOS= new ArrayList<>();
        for (Lek l: lekovi) {
            lekDTOS.add(new LekDTO(l));
        }
        return new ResponseEntity<>(lekDTOS, HttpStatus.OK);
    }

    @PostMapping(path = "/dodaj", consumes = "application/json")
    public ResponseEntity<Void> addDijagnoza(@RequestBody LekDTO lekDTO) {
        Lek lek = new Lek(lekDTO.getNazivLeka(), lekDTO.getOpisLeka());
        Lek l=lekService.add(lek);
        if(l == null){
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
        return new ResponseEntity<>((HttpStatus.CREATED));

    }

    @DeleteMapping(value = "/obrisi{id}")
    public ResponseEntity<Void> deleteDijagnoza(@PathVariable Long id) {
        lekService.deleteById(id);
        return new ResponseEntity<>((HttpStatus.OK));

    }
}
