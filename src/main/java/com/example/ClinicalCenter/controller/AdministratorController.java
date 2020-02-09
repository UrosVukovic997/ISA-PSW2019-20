package com.example.ClinicalCenter.controller;

import antlr.ASTNULLType;
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

    @Autowired
    private OdsustvoOdmorService odsustvoOdmorService;

    @Autowired
    private TipPregledaService tipPregledaService;


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

    @GetMapping(path = "/getAllOdOd", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<OdsustvoOdmor>> getAllOdOd(){
        List<OdsustvoOdmor> OdsustvoOdmor = odsustvoOdmorService.findAll();


        return new ResponseEntity<>(OdsustvoOdmor,HttpStatus.OK);
    }
    /*
    @GetMapping(path = "/getAllTerminiOdOd", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<Termin>> getAllTerminiOdOd(){
        List<OdsustvoOdmor> OdsustvoOdmor = odsustvoOdmorService.findAll();
        List<Termin> termini = terminService.findAll();
        List<Termin> terminiOdOd = new ArrayList<>();
        for(Termin t: termini){
           if(t.getOdsustvoOdmor() != null) {
               terminiOdOd.add(t);
           }
        }

        return new ResponseEntity<>(terminiOdOd,HttpStatus.OK);
    }
    */
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
    // id termina
    @GetMapping(value = "/getMedOsoblje/{id}")
    public ResponseEntity <?> getMedOsoblje(@PathVariable Long id){
        OdsustvoOdmor odsOdmor = odsustvoOdmorService.findById(id);
        Lekar lekar = new Lekar();
        Sestra sestra = new Sestra();
        lekar = odsOdmor.getLekar();
        sestra = odsOdmor.getSestra();
        if(lekar == null) {
            return new ResponseEntity<>(sestra,HttpStatus.OK);
        } else if(sestra == null) {

            return new ResponseEntity<>(lekar, HttpStatus.OK);
        }
        return null;
    }

    @GetMapping(value = "/allLekari")
    public ResponseEntity<List<Lekar>> getAllLekari() {

        List<Lekar> lekari = lekarService.findAll();

        return new ResponseEntity<>(lekari, HttpStatus.OK);
    }
    @GetMapping(value = "/allTipovi")
    public ResponseEntity<List<TipPregleda>> getAllTipoviPregleda() {

        List<TipPregleda> tipPregledas = tipPregledaService.findAll();

        return new ResponseEntity<>(tipPregledas, HttpStatus.OK);
    }
}
