package com.example.ClinicalCenter.controller;


import com.example.ClinicalCenter.dto.*;

import com.example.ClinicalCenter.model.*;
import com.example.ClinicalCenter.service.*;

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

    @Autowired
    private KartonService kartonService;



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
    public ResponseEntity<List<LekarPacDTO>> getLekarOdTipa(@PathVariable String nazivTipa) {

        String[] parsirano = nazivTipa.split(",");
        TipPregleda tp = tipPregledaService.findByNaziv(parsirano[0]);
        Set<Lekar> lekari = tp.getLekari();
        List<LekarPacDTO> lekarDTOs =new ArrayList<>();
        for (Lekar lekar : lekari){
            lekarDTOs.add(new LekarPacDTO(lekar));
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
        String usernamePac = parsirano[3];

        System.out.println(sat + " " + datum + " " + emailLekara);

        List<Klinika> klinikas = klinikaService.findAll();
        Pacijent pacijent = pacijentService.findByUsername(usernamePac);
        Lekar lekar = lekarService.findByEmail(emailLekara);
        Set<Termin> termins = lekar.getTermin();
        List<TerminPacDTO> terminPacDTOs =new ArrayList<>();
        //System.out.println("1");
        for (Termin t : termins) {
            if(t.isSlobodan() && !t.isOdsustvo())
            {

                String[] parsirano1 = t.getPocetak().toString().split(" ");
                if(parsirano1[0].equals(datum) && parsirano1[1].equals(sat))
                {
                    t.setSlobodan(false);
                    System.out.println(t.isSlobodan());
                    terminService.save(t);

                    Set<Pacijent> pacijents = lekar.getPacijenti();
                    pacijents.add(pacijent);
                    lekarService.save(lekar);

                    for (Klinika k : klinikas){
                        Set<Lekar> lekari = k.getLekari();
                        System.out.println("nasao lekare");
                        for( Lekar l : lekari)
                        {
                            //System.out.println("nasao lekara");

                            //System.out.println(pacijents);

                            Set<Pacijent> pacijents1 = k.getPacijents();
                            //System.out.println(pacijents1);
                            pacijents1.add(pacijent);
                            //System.out.println(pacijent.getId());
                           // System.out.println(k.getId());
                           // System.out.println(l.getId());

                            klinikaService.add(k);
                        }
                    }
                }

            }
        }
        //System.out.println(terminPacDTOs);


        return new ResponseEntity<>( HttpStatus.OK);
    }


    @GetMapping(value = "/getSelectedKlinPac/{spojeno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SearchKlinPacDTO>> getSelectedKlinPac(@PathVariable String spojeno) {

        String[] parsirano = spojeno.split(",");
        String grad = parsirano[0];
        String tipPregleda = parsirano[1];
        String cena = parsirano[2];
        String datum = parsirano[3];

        List<Klinika> klinike = klinikaService.findAll();
        List<SearchKlinPacDTO> searchKlinPacDTOS = new ArrayList<>();

        for (Klinika klinika : klinike)
        {
            if(klinika.getGrad() != null && klinika.getGrad().equals(grad))
            {
                Set<TipPregleda> tipoviPregleda =klinika.getTipPregleda();
                for( TipPregleda tp : tipoviPregleda)
                {
                    if(tp.getNaziv() != null && tp.getNaziv().equals(tipPregleda))
                    {
                        Set<Lekar> lekari = tp.getLekari();
                        for(Lekar lekar : lekari)
                        {
                            Set<Termin> termini = lekar.getTermin();
                            for (Termin termin :termini)
                            {
                                if(termin.getDatum() != null && termin.getDatum().equals(datum))
                                {
                                    searchKlinPacDTOS.add(new SearchKlinPacDTO(klinika.getNazivKlinike(),klinika.getOcena(),klinika.getGrad(),tp.getCena()));
                                }
                            }
                        }
                    }
                }
            }
        }


        return new ResponseEntity<>(searchKlinPacDTOS, HttpStatus.OK);
    }


    @GetMapping(value = "/getSearchLekarPac/{spojeno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SearchLekarPacDTO>> getSearchLekarPac(@PathVariable String spojeno) {

        String[] parsirano = spojeno.split(",");
        String grad = parsirano[0];
        String tipPregleda = parsirano[1];
        String cena = parsirano[2];
        String datum = parsirano[3];
        String nazivKlinike = parsirano[4];

        Klinika klinika = klinikaService.findByNazivKlinike(nazivKlinike);
        List<SearchLekarPacDTO> searchLekarPacDTOS = new ArrayList<>();


        if(klinika.getGrad() != null && klinika.getGrad().equals(grad))
        {
            Set<TipPregleda> tipoviPregleda =klinika.getTipPregleda();
            for( TipPregleda tp : tipoviPregleda)
            {
                if(tp.getNaziv() != null && tp.getNaziv().equals(tipPregleda))
                {
                    Set<Lekar> lekari = tp.getLekari();
                    for(Lekar lekar : lekari)
                    {
                        Set<Termin> termini = lekar.getTermin();
                        for (Termin termin :termini)
                        {
                            String[] pars = termin.getPocetak().toString().split(" ");
                            String satnica = pars[1];
                            if(termin.getDatum() != null && termin.getDatum().equals(datum))
                            {
                                searchLekarPacDTOS.add(new SearchLekarPacDTO(lekar.getIme(),lekar.getPrezime(),lekar.getProsecna_ocena(),satnica));
                            }
                        }
                    }

            }
        }
    }


        return new ResponseEntity<>(searchLekarPacDTOS, HttpStatus.OK);
    }


    @GetMapping(path = "/getPregledPac/{jbo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PregledPacDTO>> getTerminPac(@PathVariable int jbo){
        List<Pregled> pregledi=pregledService.findByJbo(jbo);
        List<PregledPacDTO> pregledPacDTOS = new ArrayList<>();
        for( Pregled p : pregledi) {
            Lekar l = p.getLekar();

            pregledPacDTOS.add(new PregledPacDTO(p.getPocetak(),p.getKraj(),l.getIme(),l.getPrezime()));
        }
        return new ResponseEntity<>(pregledPacDTOS, HttpStatus.OK);
    }

    @GetMapping(path = "/getKartonPac/{jbo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KartonPacDTO> getKartonPac(@PathVariable int jbo){
        Pacijent pacijent = pacijentService.findByJbo(jbo);
        Karton karton = kartonService.findByPacijent(pacijent);
        KartonPacDTO kartonPacDTO = new KartonPacDTO(jbo,karton.getBroj(),karton.getKrvnaGrupa(),karton.getDioptrija());
        return new ResponseEntity<>(kartonPacDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/getOcenaKlinike/{spojeno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getKartonPac(@PathVariable String spojeno){
        String[] splitovano = spojeno.split(",");
        String ocena = splitovano[0];
        String nazivKlinike = splitovano[1];
        String userNamePac = splitovano[2];



        Pacijent pacijent = pacijentService.findByUsername(userNamePac);

        Klinika klinika = klinikaService.findByNazivKlinike(nazivKlinike);
        double klinikaOcena = klinika.getOcena();
        for( Pacijent p : klinika.getPacijents())
        {
            if(p.getId() == pacijent.getId()){
                int pars = Integer.parseInt(ocena);
                klinikaOcena = (klinikaOcena+pars)/2;
                klinika.setOcena(klinikaOcena);
                klinikaService.add(klinika);
            }
            else{
                klinikaOcena = klinika.getOcena();
            }
        }


        return new ResponseEntity<>(klinikaOcena, HttpStatus.OK);
    }


    @GetMapping(path = "/getOceneLekara/{spojeno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOceneLekara(@PathVariable String spojeno){
        String[] splitovano = spojeno.split(",");
        String ocena = splitovano[0];
        String emailLekara = splitovano[1];

        Lekar lekar = lekarService.findByEmail(emailLekara);
        double lekarOcena = lekar.getProsecna_ocena();
        int pars = Integer.parseInt(ocena);
        lekarOcena = (lekarOcena+pars)/2;
        lekar.setProsecna_ocena(lekarOcena);
        lekarService.save(lekar);

        return new ResponseEntity<>(lekarOcena, HttpStatus.OK);
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
