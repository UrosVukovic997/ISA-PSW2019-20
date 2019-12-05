package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.dto.LekarDTO;
import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.service.LekarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public class LekarController {

    @Autowired
    private LekarService lekarService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<LekarDTO>> getAllLekari() {

        List<Lekar> lekari = lekarService.findAll();

        // convert students to DTOs
        List<LekarDTO> lekariDTO = new ArrayList<>();
        for (Lekar l : lekari) {
            lekariDTO.add(new LekarDTO(l));
        }

        return new ResponseEntity<>(lekariDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LekarDTO> getLekar(@PathVariable Long id) {

        Lekar lekar = lekarService.findOne(id);

        // Proverava da li lekar postoji
        if (lekar == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new LekarDTO(lekar), HttpStatus.OK);
    }



}
