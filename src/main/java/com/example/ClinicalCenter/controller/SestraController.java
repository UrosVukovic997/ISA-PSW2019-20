package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.dto.*;
import com.example.ClinicalCenter.model.*;
import com.example.ClinicalCenter.service.*;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/sestra")
public class SestraController {

    @Autowired
    private PacijentService pacijentService;
    @Autowired
    private SestraService sestraService;
    @Autowired
    private KlinikaService klinikaService;
    @Autowired
    private KartonService kartonService;
    @Autowired
    private ReceptService receptService;

    @GetMapping(path = "/getAll/{username}")
    public ResponseEntity<List<PacijentSestraDTO>> getAll(@PathVariable String username){
        System.out.println(username);
        String nazivKlinike = sestraService.FindByUsername(username).getKlinika();
        Set<Pacijent> pacijents = klinikaService.findByNazivKlinike(nazivKlinike).getPacijents();
        List<PacijentSestraDTO> pacijentDTOS= new ArrayList<>();
        for (Pacijent p: pacijents) {
            pacijentDTOS.add(new PacijentSestraDTO(p));
        }
        return new ResponseEntity<>(pacijentDTOS, HttpStatus.OK);
    }

    @GetMapping(path = "/getNazivKlinike/{username}")
    public ResponseEntity<List<String>> getNazivKlinike(@PathVariable String username) {
        String nazivKlinike = sestraService.FindByUsername(username).getKlinika();
        List<String> ret = new ArrayList<>();
        ret.add(nazivKlinike);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @GetMapping(path = "/getDate")
    public ResponseEntity<?> getDate(){
        KalendarDTO kalendarDTO = new KalendarDTO();
        return ResponseEntity.ok(kalendarDTO);
    }

    @GetMapping(path = "/getKarton/{jbo}")
    public ResponseEntity<KartonDTO> getKarton(@PathVariable Integer jbo){
        Pacijent p = pacijentService.findByJbo(jbo);
        Karton karton = kartonService.findByPacijent(p);
        KartonDTO kartonDTO = new KartonDTO(karton);
        return new ResponseEntity<>(kartonDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/getprofil/{username}")
    public ResponseEntity<SestraDTO> getProfil(@PathVariable String username){
        Sestra sestra = sestraService.FindByUsername(username);
        SestraDTO sestraDTO = new SestraDTO(sestra);
        return new ResponseEntity<>( sestraDTO, HttpStatus.OK);
    }

    @PostMapping(path = "/editprofil", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> editProfil(@RequestBody SestraDTO sestraDTO){
        Sestra sestra = sestraService.FindByEmail(sestraDTO.getEmail());
        sestra.setAdresa(sestraDTO.getAdresa());
        sestra.setUsername(sestraDTO.getUsername());
        sestra.setIme(sestraDTO.getIme());
        sestra.setPrezime(sestraDTO.getPrezime());
        Sestra s = sestraService.save(sestra);
        if(s != null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping(path = "/changepassword", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> changePassword(@RequestBody  ChangepasswordDTO changepasswordDTO){
        Sestra sestra = sestraService.FindByUsername(changepasswordDTO.getUsername());
        if(sestra.getLozinka().equals(changepasswordDTO.getOldPassword())){
            sestra.setLozinka(changepasswordDTO.getNewPassword());
            Sestra s = sestraService.save(sestra);
            if(s != null){
                return  new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping(path = "/recepti/{username}")
    public ResponseEntity<List<ReceptDTO>> getRecepte(@PathVariable String username){
        String klinika = sestraService.FindByUsername(username).getKlinika();
        List<Recept> recepts = receptService.findByKlinika(klinika);
        if(recepts == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<ReceptDTO> receptDTOS = new ArrayList<>();
        for(Recept recept : recepts){
            if(!recept.isOveren()){
                receptDTOS.add(new ReceptDTO(recept));
            }
        }

        return new ResponseEntity<>(receptDTOS, HttpStatus.OK);
    }

    @PostMapping(path = "/overi/{id}")
    public ResponseEntity<Void> overiRecept(@PathVariable Long id){
        Recept recept = receptService.findById(id);
        if(recept == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        recept.setOveren(true);
        receptService.save(recept);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/editKarton")
    public ResponseEntity<Void> izmeniKarton(@RequestBody KartonDTO kartonDTO) {
        Karton karton = kartonService.findByBroj(kartonDTO.getBroj());
        karton.setKrvnaGrupa(kartonDTO.getKrvnaGrupa());
        karton.setDioptrija(kartonDTO.getDioptrija());
        kartonService.save(karton);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
