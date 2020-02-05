package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.dto.*;
import com.example.ClinicalCenter.model.Kalendar;
import com.example.ClinicalCenter.model.Karton;
import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.model.Sestra;
import com.example.ClinicalCenter.service.KartonService;
import com.example.ClinicalCenter.service.KlinikaService;
import com.example.ClinicalCenter.service.PacijentService;
import com.example.ClinicalCenter.service.SestraService;
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

    @GetMapping(path = "/getKarton/{pacijent}")
    public ResponseEntity<KartonDTO> getKarton(@PathVariable Long pacijent){
        Pacijent p = pacijentService.findOne(pacijent);
        Karton karton = kartonService.findByPacijent(p);
        KartonDTO kartonDTO = new KartonDTO(karton);
        return new ResponseEntity<>(kartonDTO, HttpStatus.FOUND);
    }

    @GetMapping(path = "/getprofil/{username}")
    public ResponseEntity<SestraDTO> getProfil(@PathVariable String username){
        Sestra sestra = sestraService.FindByUsername(username);
        SestraDTO sestraDTO = new SestraDTO(sestra);
        return new ResponseEntity<>( sestraDTO, HttpStatus.OK);
    }

    @PostMapping(path = "/editprofil", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> editProfil(@RequestBody SestraDTO sestraDTO){
        System.out.println(sestraDTO.getAdresa());
        Sestra sestra = sestraService.FindByUsername(sestraDTO.getUsername());
        sestra.setAdresa(sestraDTO.getAdresa());
        sestra.setEmail(sestraDTO.getEmail());
        sestra.setIme(sestraDTO.getIme());
        sestra.setPrezime(sestraDTO.getPrezime());
        Sestra s = sestraService.save(sestra);
        if(s != null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
