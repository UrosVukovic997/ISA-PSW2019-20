package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.dto.LekDTO;
import com.example.ClinicalCenter.dto.LekarDTO;
import com.example.ClinicalCenter.model.Klinika;
import com.example.ClinicalCenter.model.Lek;
import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.service.LekService;
import com.example.ClinicalCenter.service.PacijentService;
import com.example.ClinicalCenter.service.LekarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.dto.PacijentDTO;

import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/lekar")
public class LekarController {

    @Autowired
    private LekarService lekarService;

    @Autowired
    private PacijentService pacijentService;


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

    @GetMapping(path = "/licni_profil/getLekar/{id}")
    public ResponseEntity<LekarDTO> getLekar(@PathVariable Long id) {

        Lekar lekar = lekarService.findOne(id);

        // Proverava da li lekar postoji
        if (lekar == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new LekarDTO(lekar), HttpStatus.OK);
    }
    //'/pacijenti/getAll'
    @GetMapping(path = "/pacijenti/getAll")
    public ResponseEntity<List<PacijentDTO>> getAll(){
        List<Pacijent> pacijenti=pacijentService.findAll();
        List<PacijentDTO> pacijentDTOS= new ArrayList<>();
        for (Pacijent p: pacijenti) {
            System.out.println(p.getEmail());
            pacijentDTOS.add(new PacijentDTO(p));
        }
        return new ResponseEntity<>(pacijentDTOS, HttpStatus.OK);
    }

    @PostMapping(path = "/izmeniProfil")
    public ResponseEntity<LekarDTO> izmeniLekara(@RequestBody LekarDTO noviLekar) {
        System.out.println(noviLekar.getId());
        System.out.println(noviLekar.getKorIme());

        Lekar lekar = lekarService.save(noviLekar);

        return new ResponseEntity<>(new LekarDTO(lekar), HttpStatus.OK);
    }
}
