package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.dto.AdministratorDTO;
import com.example.ClinicalCenter.dto.LekarDTO;
import com.example.ClinicalCenter.dto.SalaDTO;
import com.example.ClinicalCenter.model.*;
import com.example.ClinicalCenter.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/admin")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private KlinikaService klinikaService;

    @Autowired
    private SalaService salaService;

    @Autowired
    private LekarService lekarService;

    @Autowired
    private TerminService terminService;

    @PostMapping(path = "/dodaj", consumes = "application/json")
    public ResponseEntity<Void> addAdmin(@RequestBody AdministratorDTO administratorDTO) {

        Administrator administrator = new Administrator(administratorDTO);
        Administrator a=administratorService.add(administrator);
        Klinika klinika = klinikaService.findByNazivKlinike(administratorDTO.getKlinika());

        if(a == null){
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
        klinika.addAdministrator(a);
        klinikaService.add(klinika);
        return new ResponseEntity<>((HttpStatus.CREATED));

    }

    @GetMapping(path = "/getAllTermini/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<Termin>> getAllTermini(@PathVariable Long id){

        Sala sala = salaService.findById(id);
        List<Termin> termini_Svi = terminService.findAll();
        List<Termin> termini_Sa_Salom = new ArrayList<>();
        for(Termin t: termini_Svi) {
            if(t.getSala().equals(sala)) {
                termini_Sa_Salom.add(t);
            }
        }

        return new ResponseEntity<>(termini_Sa_Salom,HttpStatus.OK);
    }

    @GetMapping(path = "/getAllTerminiOdOd", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<Termin>> getAllTerminiOdOd(){
        List<Termin> termini = terminService.findAll();
        List<Termin> teminiOdOd = new ArrayList<>();


        return new ResponseEntity<>(teminiOdOd,HttpStatus.OK);
    }

    @GetMapping(path = "/getAllSale", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<Sala>> getAllSale(){
        List<Sala> sale = salaService.findAll();

        return new ResponseEntity<>(sale,HttpStatus.OK);
    }

    @GetMapping(path = "/getSalaById/{id}")
    public ResponseEntity <List<Sala>> getSala(@PathVariable Long id){
        Sala sala = salaService.findById(id);

        return new ResponseEntity(sala,HttpStatus.OK);
    }
    @GetMapping(value = "/getAll/{klinika}")
    public ResponseEntity<List<AdministratorDTO>> getAllByKlinika(@PathVariable String klinika){
        /*List<Administrator> administrators=administratorService.findAll();
        List<AdministratorDTO> administratorDTOS= new ArrayList<>();
        for (Administrator a: administrators) {
            if(a.getKlinika().equals(klinika))
                administratorDTOS.add(new AdministratorDTO(a));
        }

         */
        Set<Administrator> administrators = klinikaService.findByNazivKlinike(klinika).getAdministrators();
        List<AdministratorDTO> administratorDTOS= new ArrayList<>();
        for (Administrator a: administrators) {
            administratorDTOS.add(new AdministratorDTO(a));
        }
        return new ResponseEntity<>(administratorDTOS,HttpStatus.OK);
    }

    @DeleteMapping(value = "/obrisi{id}")
    public ResponseEntity<Void> deleteKlinika(@PathVariable Long id) {
        administratorService.deleteById(id);
        return new ResponseEntity<>((HttpStatus.OK));

    }
    /*
    @GetMapping(value = "/getAllLekari")
    public ResponseEntity <LekarDTO> getAllLekari(@PathVariable TipPregleda tipPregleda){
        List<Lekar> lekari=lekarService.findAll();
        List<LekarDTO> lekarDTOS= new ArrayList<>();

        for (Lekar l: lekari) {
            if(l.getSpecijalnost().equals(lekar) == )
                administratorDTOS.add(new AdministratorDTO(a));
        }


        Set<Administrator> administrators = klinikaService.findByNazivKlinike(klinika).getAdministrators();
        List<AdministratorDTO> administratorDTOS= new ArrayList<>();
        for (Administrator a: administrators) {
            administratorDTOS.add(new AdministratorDTO(a));
        }
        return new ResponseEntity<>(administratorDTOS,HttpStatus.OK);
    }
    */
}
