package com.example.ClinicalCenter.controller;


import com.example.ClinicalCenter.dto.PacijentDTO;
import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.service.PacijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/pacijenti")
public class PacijentController {

    @Autowired
    private PacijentService pacijentService;

    @GetMapping(value = "/zahtev")
    public ResponseEntity<List<PacijentDTO>> pronadjiNeOdobrene() {
        List<Pacijent> pacijenti = pacijentService.pronadjiNeOdobrene();
        List<PacijentDTO> PacijentiDTO = new ArrayList<>();
        for (Pacijent p : pacijenti) {
            PacijentiDTO.add(new PacijentDTO(p));
        }
        return new ResponseEntity<>(PacijentiDTO, HttpStatus.OK);


    }

    @PostMapping(path = "/registruj", consumes = "application/json")
    public ResponseEntity<Void> signUp(@RequestBody PacijentDTO pacijentDTO)  {
        System.out.println("USLO");

        Pacijent p = pacijentService.findOneByEMail(pacijentDTO.getemail());
        if (p != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        System.out.println("USLO1");

        Pacijent pacijent = new Pacijent();
        pacijent.setImePacijenta(pacijentDTO.getImePacijenta());
        pacijent.setPrezimePacijenta(pacijentDTO.getPrezimePacijenta());
        pacijent.setemail(pacijentDTO.getemail());
        pacijent.setLozinka(pacijentDTO.getLozinka());
        pacijent.setAdresa(pacijentDTO.getAdresa());
        pacijent.setGrad(pacijentDTO.getGrad());
        pacijent.setDrzava(pacijentDTO.getDrzava());
        pacijent.setBrojTelefona(pacijentDTO.getBrojTelefona());
        pacijent.setJBO(pacijentDTO.getJBO());
        System.out.println("USLO2");


        pacijent = pacijentService.save(pacijent);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
