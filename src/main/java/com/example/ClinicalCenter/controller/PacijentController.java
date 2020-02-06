package com.example.ClinicalCenter.controller;


import com.example.ClinicalCenter.dto.PacijentDTO;
import com.example.ClinicalCenter.dto.PacijentEditDTO;
import com.example.ClinicalCenter.dto.PacijentZakaziDTO;
import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.model.Pregled;
import com.example.ClinicalCenter.model.Termin;
import com.example.ClinicalCenter.service.PacijentService;
import com.example.ClinicalCenter.service.PregledService;
import com.example.ClinicalCenter.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/pacijenti")
public class PacijentController {

    @Autowired
    private PacijentService pacijentService;

    @Autowired
    private TerminService terminService;

    @Autowired
    private PregledService pregledService;



    @GetMapping(value = "/zahtev", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PacijentDTO>> pronadjiNeOdobrene() {
       List<Pacijent> pacijenti = pacijentService.pronadjiNeOdobrene();
       List<PacijentDTO> PacijentiDTO = new ArrayList<>();
       for(Pacijent p : pacijenti){
           PacijentiDTO.add(new PacijentDTO(p));
       }
       return new ResponseEntity<>(PacijentiDTO, HttpStatus.OK);

    }


    @GetMapping(value = "/nadji/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PacijentEditDTO> getPacijent(@PathVariable String username) {

        Pacijent pacijent = pacijentService.findByUsername(username);

        if (pacijent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new PacijentEditDTO(pacijent), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PacijentDTO>> getPacijentPage(Pageable page) {

        // page object holds data about pagination and sorting
        // the object is created based on the url parameters "page", "size" and "sort"
        Page<Pacijent> pacijenti = pacijentService.findAll(page);

        // convert students to DTOs
        List<PacijentDTO> pacijentiDTO = new ArrayList<>();
        for (Pacijent p : pacijenti) {
            pacijentiDTO.add(new PacijentDTO(p));
        }

        return new ResponseEntity<>(pacijentiDTO, HttpStatus.OK);
    }

    @PostMapping(path = "/registruj", consumes = "application/json")
    public ResponseEntity<Void> signUp(@RequestBody PacijentDTO pacijentDTO, UriComponentsBuilder ucBuilder)  {
        //System.out.println("USLO");

        Pacijent p = pacijentService.findOneByEMail(pacijentDTO.getEmail());
        if (p != null) {
           //throw new ResourceConflictException(pacijentDTO.getId(), "Korisnicko ime je zauzeto.");


        }

        //System.out.println("USLO1");

        Pacijent pacijent = new Pacijent();
        pacijent.setImePacijenta(pacijentDTO.getImePacijenta());
        pacijent.setPrezimePacijenta(pacijentDTO.getPrezimePacijenta());
        pacijent.setEmail(pacijentDTO.getEmail());
        pacijent.setPassword(pacijentDTO.getPassword());
        pacijent.setAdresa(pacijentDTO.getAdresa());
        pacijent.setGrad(pacijentDTO.getGrad());
        pacijent.setDrzava(pacijentDTO.getDrzava());
        pacijent.setBrojTelefona(pacijentDTO.getBrojTelefona());
        pacijent.setJbo(pacijentDTO.getJbo());
        pacijent.setUsername(pacijentDTO.getUsername());
        pacijent.setRodjen(pacijentDTO.getRodjen());
        pacijent.setOdobren(false);
        pacijent.setPotvrdio(false);
        //System.out.println("USLO2");


        pacijent = pacijentService.save(pacijent);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/pacijent/registruj/{userId}").buildAndExpand(pacijent.getId()).toUri());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }




    @PostMapping(path = "/zamena", consumes = "application/json")
    public ResponseEntity<Void> changePac(@RequestBody PacijentEditDTO pacijentEditDTO)  {
        //System.out.println("USLO");

        System.out.println(pacijentEditDTO.getEmail());
        Pacijent p = pacijentService.findOneByEMail(pacijentEditDTO.getEmail());
        if (p == null) {
            // throw new ResourceConflictException(pacijentDTO.getId(), "Korisnicko ime je zauzeto.");

            System.out.println("jeste");
        }


        //System.out.println("USLO1");

        //Pacijent pacijent = new Pacijent();
        p.setImePacijenta(pacijentEditDTO.getImePacijenta() );
        p.setPrezimePacijenta( pacijentEditDTO.getPrezimePacijenta());
        p.setUsername( pacijentEditDTO.getUsername());
        p.setDrzava( pacijentEditDTO.getDrzava());
        p.setAdresa( pacijentEditDTO.getAdresa());
        p.setGrad( pacijentEditDTO.getGrad());
        p.setBrojTelefona( pacijentEditDTO.getBrojTelefona());
        p.setRodjen( pacijentEditDTO.getRodjen());
        //System.out.println("USLO2");


        p = pacijentService.save(p);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/nadjiKliniku/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PacijentEditDTO> getKlinika(@PathVariable String email) {

        Pacijent pacijent = pacijentService.findOneByE_Mail(email);

        if (pacijent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new PacijentEditDTO(pacijent), HttpStatus.OK);
    }


    @PostMapping(path = "/zakazivanje", consumes = "application/json")
    public ResponseEntity<Void> Zakazi(@RequestBody PacijentZakaziDTO pacijentZakaziDTO)  {

        Pacijent p = pacijentService.findOneByEMail(pacijentZakaziDTO.getEmail());
        if (p == null) {
            System.out.println("jeste");
        }
        Termin t = new Termin();
        Pregled pregled= new Pregled();
        Lekar lekar = new Lekar();

        pregled.setEmail(pacijentZakaziDTO.getEmail());
        pregled.setIme_pacijenta(pacijentZakaziDTO.getImePacijenta());
        pregled.setJbo(pacijentZakaziDTO.getJbo());
        pregled.setPrezime_pacijenta(pacijentZakaziDTO.getPrezimePacijenta());
        pregled.setLekar(pacijentZakaziDTO.getLekar());

        t.setPocetak(pacijentZakaziDTO.getPocetak());
        t.setKraj(pacijentZakaziDTO.getKraj());



        // fali i pronalazak lekara preko emaila i njegovo setovanje za ovaj pregled

        // p = pregledService.save(pregled);
        // t= terminService.save(t);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
