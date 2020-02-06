package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.dto.*;
import com.example.ClinicalCenter.model.*;
import com.example.ClinicalCenter.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private PregledService pregledService;

    @Autowired
    private DijagnozaService dijagnozaService;


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
            if (p.isObrisan() == false) {
                System.out.println(p.getEmail());
                pacijentDTOS.add(new PacijentDTO(p));
            }
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

    @PostMapping(path = "/zakaziPregled/{id}")
    public ResponseEntity<?> zakaziPregled(@RequestBody PregledDTO pregledDTO, @PathVariable Long id) {
        this.pregledService.zakaziPregled(pregledDTO, id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/obrisi{id}")
    public ResponseEntity<Void> deletePacijent(@PathVariable Long id) {
        Pacijent pacijent = pacijentService.findOne(id);
        pacijentService.delete(pacijent);
        pacijentService.save(pacijent);

        return new ResponseEntity<>((HttpStatus.OK));

    }

    @GetMapping(value = "/getPacijent{id}")
    public Pacijent getPacijent(@PathVariable Long id) {

        return this.pacijentService.findOne(id);
    }
    /*
    @GetMapping(value = "/getDijagPacijent{id}")
    public List<Dijagnoza> getDijagnoze(@PathVariable Long id) {

        return this.dijagnozaService.dijagnozePacijenta(pacijentService.findOne(id));
    }

    */
}
