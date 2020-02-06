package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.dto.LekarDTO;
import com.example.ClinicalCenter.dto.TipPregledaDTO;
import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.model.TipPregleda;
import com.example.ClinicalCenter.service.LekarService;
import com.example.ClinicalCenter.service.TipPregledaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/lekar")
public class TipPregledaController {

    @Autowired
    private TipPregledaService tipPregledaService;

    @GetMapping(value = "/getTipPregleda")
    public ResponseEntity<List<TipPregledaDTO>> getAllTipPregleda() {

        List<TipPregleda> tipoviPregleda = tipPregledaService.findAll();

        // convert students to DTOs
        List<TipPregledaDTO> tipPregledaDTO = new ArrayList<>();
        for (TipPregleda tp : tipoviPregleda) {
            TipPregledaDTO tpDTO = new TipPregledaDTO(tp);
            tipPregledaDTO.add(new TipPregledaDTO(tp));
            System.out.println(tpDTO.getNaziv());
        }

        return new ResponseEntity<>(tipPregledaDTO, HttpStatus.OK);
    }

}
