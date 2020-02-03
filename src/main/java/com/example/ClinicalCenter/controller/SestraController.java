package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.dto.KalendarDTO;
import com.example.ClinicalCenter.dto.PacijentDTO;
import com.example.ClinicalCenter.model.Kalendar;
import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.service.KlinikaService;
import com.example.ClinicalCenter.service.PacijentService;
import com.example.ClinicalCenter.service.SestraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<PacijentDTO>> getAll(String username){
        String nazivKlinike = sestraService.FindByUsername(username).getKlinika();
        Set<Pacijent> pacijents = klinikaService.findByNazivKlinike(nazivKlinike).getPacijents();
        List<PacijentDTO> pacijentDTOS= new ArrayList<>();
        for (Pacijent p: pacijents) {
            pacijentDTOS.add(new PacijentDTO(p));
        }
        return new ResponseEntity<>(pacijentDTOS, HttpStatus.OK);
    }

    @GetMapping(path = "/getDate")
    public ResponseEntity<?> getDate(){
        KalendarDTO kalendarDTO = new KalendarDTO();
        return ResponseEntity.ok(kalendarDTO);
    }
}
