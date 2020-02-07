package com.example.ClinicalCenter.controller;


import com.example.ClinicalCenter.dto.*;

import com.example.ClinicalCenter.model.*;
import com.example.ClinicalCenter.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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

    @Autowired
    private KlinikaService klinikaService;

    @Autowired
    private LekarService lekarService;

    @Autowired
    private TipPregledaService tipPregledaService;



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
        pacijent.setObrisan(false);
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


    @GetMapping(path = "/getKlinPac")
    public ResponseEntity<List<KlinikaTipDTO>> getTipPregledaKlinika(){
        List<Klinika> klinike=klinikaService.findAll();
        List<KlinikaTipDTO> klinikaTipDTOs = new ArrayList<>();
        for( Klinika k : klinike) {
            Set<TipPregleda> tp = k.getTipPregleda();
            List<TipPregledaDTO> tipPregledaDTOs = new ArrayList();
            for (TipPregleda tipP : tp) {
                tipPregledaDTOs.add(new TipPregledaDTO(tipP));
            }
            klinikaTipDTOs.add(new KlinikaTipDTO(tipPregledaDTOs, k));
        }
        return new ResponseEntity<>(klinikaTipDTOs, HttpStatus.OK);
    }
    @GetMapping(value = "/getLekarOdTipa/{nazivTipa}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LekarDTO>> getLekarOdTipa(@PathVariable String nazivTipa) {

        TipPregleda tp = tipPregledaService.findByNaziv(nazivTipa);
        Set<Lekar> lekari = tp.getLekari();
        List<LekarDTO> lekarDTOs =new ArrayList<>();
        for (Lekar lekar : lekari){
            lekarDTOs.add(new LekarDTO(lekar));
        }

        return new ResponseEntity<>(lekarDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "/vremeLekaraFTDatum/{spojeno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminPacDTO>> getVremeOdLekaraFTDatuma(@PathVariable String spojeno) {

        String[] parsirano = spojeno.split(",");
        String vreme = parsirano[0];
        String emailLekara = parsirano[1];

        System.out.println(vreme + " " + emailLekara);

        Lekar lekar = lekarService.findByEmail(emailLekara);
        Set<Termin> termins = lekar.getTermin();
        List<TerminPacDTO> terminPacDTOs =new ArrayList<>();
        //System.out.println("1");
        for (Termin t : termins) {
           /* System.out.println(t);
            System.out.println(t.isSlobodan());
            System.out.println(t.getDatum());
            System.out.println(vreme);*/

            if(t.isSlobodan() && t.getDatum().equals(vreme))
            {
                //System.out.println("usao");
                String[] parsirano1 = t.getPocetak().toString().split(" ");
                System.out.println(parsirano1[1]);
                terminPacDTOs.add(new TerminPacDTO(parsirano1[1]));

            }
        }
        //System.out.println(terminPacDTOs);


        return new ResponseEntity<>(terminPacDTOs, HttpStatus.OK);
    }


    @GetMapping(value = "/zakaziPregledPac/{spojeno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminPacDTO>> getZakaziPregledPac(@PathVariable String spojeno) {

        String[] parsirano = spojeno.split(",");
        String sat = parsirano[0];
        String datum = parsirano[1];
        String emailLekara = parsirano[2];

        System.out.println(sat + " " + datum + " " + emailLekara);

        Lekar lekar = lekarService.findByEmail(emailLekara);
        Set<Termin> termins = lekar.getTermin();
        List<TerminPacDTO> terminPacDTOs =new ArrayList<>();
        //System.out.println("1");
        for (Termin t : termins) {
            if(t.isSlobodan())
            {

                String[] parsirano1 = t.getPocetak().toString().split(" ");
                if(parsirano1[0].equals(datum) && parsirano1[1].equals(sat))
                {
                    t.setSlobodan(false);
                    System.out.println(t.isSlobodan());
                    terminService.save(t);
                }

            }
        }
        //System.out.println(terminPacDTOs);


        return new ResponseEntity<>( HttpStatus.OK);
    }


}




/*
Set<Lekar> l = k.getLekari();
        List<LekarKlinikaDTO> lekarKlinikaDTOs = new ArrayList<>();
        for(Lekar lekar : l)
        {
            lekarKlinikaDTOs.add(new LekarKlinikaDTO(lekar));
        }
 */
