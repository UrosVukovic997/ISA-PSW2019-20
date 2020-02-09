package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.dto.*;
import com.example.ClinicalCenter.model.*;
import com.example.ClinicalCenter.service.AdminKcService;
import com.example.ClinicalCenter.service.KartonService;
import com.example.ClinicalCenter.service.PacijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/adminKC")
public class AdminKcController {

    @Autowired
    private AdminKcService adminKcService;
    @Autowired
    private PacijentService pacijentService;
    @Autowired
    private KartonService kartonService;

    @PostMapping(path = "/dodaj", consumes = "application/json")
    public ResponseEntity<Void> addAdminKC(@RequestBody AdminKcDTO adminKcDTO) {

        AdminKC adminKC = new AdminKC(adminKcDTO);
        AdminKC a=adminKcService.save(adminKC);
        if(a == null){
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
        return new ResponseEntity<>((HttpStatus.CREATED));

    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public ResponseEntity<List<AdminKcDTO>> getAll(){
        List<AdminKC> adminsKC = adminKcService.getAll();
        List<AdminKcDTO> adminKcDTOS = new ArrayList<>();
        for (AdminKC a: adminsKC) {
            adminKcDTOS.add(new AdminKcDTO(a));
        }
        return new ResponseEntity<>(adminKcDTOS, HttpStatus.OK);
    }


    @PostMapping(path = "/azuriraj", consumes = "application/json")
    public ResponseEntity<Void> azuriraj(@RequestBody AdminKcDTO adminKcDTO) {

        AdminKC adminKc = adminKcService.getByEmail(adminKcDTO.getEmail());
        adminKc.setIme(adminKcDTO.getIme());
        adminKc.setPrezime(adminKcDTO.getPrezime());
        adminKc.setUsername(adminKcDTO.getUsername());

        AdminKC a = adminKcService.save(adminKc);

        if(a == null){
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
        /*
        int res = adminKcService.updateAdmin(adminKcDTO.getId(),adminKcDTO.getIme(),adminKcDTO.getPrezime(),adminKcDTO.getEmail());
        if(res != 0){
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }

        */
        return new ResponseEntity<>((HttpStatus.OK));
    }

    @GetMapping(path = "/checkUsername", consumes = "application/json")
    public ResponseEntity<String> checkUsername(@RequestBody String username){
        AdminKC adminKC = adminKcService.getByUsername(username);
        if(adminKC != null)
            return new ResponseEntity<>(username,HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @PostMapping(path = "/changepassword", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> changePassword(@RequestBody ChangepasswordDTO changepasswordDTO){

        AdminKC adminKC = adminKcService.getByUsername(changepasswordDTO.getUsername());
        if(adminKC == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(adminKC.getLozinka().equals(changepasswordDTO.getOldPassword())){
            adminKC.setLozinka(changepasswordDTO.getNewPassword());
            adminKC.setPrvoPrijavljivanje(false);
            AdminKC a =adminKcService.save(adminKC);
            if(a != null){
                return  new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping(path = "/getprofil/{username}")
    public ResponseEntity<AdminKcDTO> getProfil(@PathVariable String username){
        AdminKC adminKC = adminKcService.getByUsername(username);
        AdminKcDTO adminKcDTO = new AdminKcDTO(adminKC);
    return new ResponseEntity<>( adminKcDTO, HttpStatus.OK);
    }

    @PostMapping(path = "/registruj", consumes = "application/json")
    public ResponseEntity<Void> registruj(@RequestBody AdminKcDTO adminKcDTO) {

        AdminKC adminKc = new AdminKC(adminKcDTO);
        AdminKC a = adminKcService.save(adminKc);

        if(a == null){
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
        /*
        int res = adminKcService.updateAdmin(adminKcDTO.getId(),adminKcDTO.getIme(),adminKcDTO.getPrezime(),adminKcDTO.getEmail());
        if(res != 0){
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }

        */
        return new ResponseEntity<>((HttpStatus.OK));
    }

    @DeleteMapping(value = "/obrisi/{id}")
    public ResponseEntity<Void> deleteAdminKC(@PathVariable Long id) {
        adminKcService.delete(id);
        return new ResponseEntity<>((HttpStatus.OK));

    }
    @GetMapping(path = "/getBezKartona")
    public ResponseEntity<List<PacijentSestraDTO>> getBezKartona(){
        List<PacijentSestraDTO> pacijentSestraDTOS = new ArrayList<>();
        for(Pacijent p : pacijentService.findAll()){
            Karton k = kartonService.findByPacijent(p);
            if(k == null){
                PacijentSestraDTO pacijentSestraDTO = new PacijentSestraDTO(p);
                pacijentSestraDTOS.add(pacijentSestraDTO);
            }
        }

        return new ResponseEntity<>(pacijentSestraDTOS, HttpStatus.OK);
    }

    @PostMapping(path = "/kreirajKarton/{jbo}")
    public ResponseEntity<Void> kreirajKarton(@PathVariable Integer jbo) {
        Pacijent p = pacijentService.findByJbo(jbo);
        Karton k = new Karton();
        k.setBroj(100+ Integer.parseInt(p.getId().toString()));
        k.setPacijent(p);
        k.setDioptrija("");
        k.setKrvnaGrupa("");
        kartonService.save(k);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/prvoPrij/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> getPrvoPrijavljivanje(@PathVariable String username) {
        AdminKC a = adminKcService.getByUsername(username);
        Boolean ft = a.getPrvoPrijavljivanje();
        return new ResponseEntity<>(ft,HttpStatus.OK);
    }


    }
