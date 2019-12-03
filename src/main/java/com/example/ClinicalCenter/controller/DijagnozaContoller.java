package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.dto.DijagnozaDTO;
import com.example.ClinicalCenter.model.Dijagnoza;
import com.example.ClinicalCenter.service.DijagnozaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/dijagnoza")
public class DijagnozaContoller {

    @Autowired
    private DijagnozaService dijagnozaService;


    @PostMapping(path = "/dodaj", consumes = "application/json")
    public ResponseEntity<Void> addDijagnoza(@RequestBody DijagnozaDTO dijagnozaDTO) {

        Dijagnoza dijagnoza = new Dijagnoza(dijagnozaDTO.getNazivDijagnoze(), dijagnozaDTO.getOpisDijagnoze());
        Dijagnoza d=dijagnozaService.add(dijagnoza);
        if(d == null){
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
        return new ResponseEntity<>((HttpStatus.CREATED));

    }

    @DeleteMapping(value = "/obrisi{id}")
    public ResponseEntity<Void> deleteDijagnoza(@PathVariable Long id) {
        dijagnozaService.deleteById(id);
        return new ResponseEntity<>((HttpStatus.OK));

    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<DijagnozaDTO>> getAll(){
        List<Dijagnoza> dijagnoze=dijagnozaService.findAll();
        List<DijagnozaDTO> dijagnozaDTOS= new ArrayList<>();
        for (Dijagnoza d: dijagnoze) {
            dijagnozaDTOS.add(new DijagnozaDTO(d));
        }
        return new ResponseEntity<>(dijagnozaDTOS,HttpStatus.OK);
    }
}
