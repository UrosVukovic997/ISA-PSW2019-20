package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.dto.AdministratorDTO;
import com.example.ClinicalCenter.model.Administrator;
import com.example.ClinicalCenter.model.Klinika;
import com.example.ClinicalCenter.service.AdministratorService;
import com.example.ClinicalCenter.service.KlinikaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping(path = "/dodaj", consumes = "application/json")
    public ResponseEntity<Void> addAdmin(@RequestBody AdministratorDTO administratorDTO) {

        Administrator administrator = new Administrator(administratorDTO);
        Administrator a=administratorService.add(administrator);
        Klinika klinika = klinikaService.findByNazivKlinike(administratorDTO.getKlinika());
        System.out.println(klinika.getNazivKlinike());
        if(a == null){
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
        klinika.addAdministrator(a);
        Klinika k = klinikaService.add(klinika);
        if(k==null)
            System.out.println("sranjeeee");
        return new ResponseEntity<>((HttpStatus.CREATED));

    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<AdministratorDTO>> getAll(){
        List<Administrator> administrators=administratorService.findAll();
        List<AdministratorDTO> administratorDTOS= new ArrayList<>();
        for (Administrator a: administrators) {
            administratorDTOS.add(new AdministratorDTO(a));
        }
        return new ResponseEntity<>(administratorDTOS,HttpStatus.OK);
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
       // Set<Administrator> administrators = klinikaService.findByNazivKlinike(klinika).getAdministrators();
        List<Administrator> administrators = administratorService.findAllByKlinika(klinika);

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
}
