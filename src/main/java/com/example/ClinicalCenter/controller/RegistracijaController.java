package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.service.RegistracijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/registracija")
public class RegistracijaController {

    @Autowired
    private RegistracijaService registracijaService;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Environment env;

    @PostMapping (value = "/odobri{id}")
    public ResponseEntity<Void> odobri(@PathVariable Long id){
        Pacijent p=registracijaService.odobriKorsnika(id);

        if(p != null) {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(p.getEmail());
            mail.setFrom(env.getProperty("spring.mail.username"));
            mail.setSubject("Potvdite nalog");
            mail.setText("Pozdrav " + p.getImePacijenta() + ",\n\nhvala Vam što ste se registrovali na našoj klinici." +
                    "Administrator je odobrio Vaš zahtrv. Molimo vas da aktivirate nalog pritiskom na sledeci link" +
                    "\n\n http://localhost:4200/aktivirajNalog/"+p.getId());
            javaMailSender.send(mail);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping (value = "/obrisi{id}")
    public ResponseEntity<Void> obrisiStudenta(@PathVariable Long id){
        registracijaService.obrisiKorisnika(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping (value = "/potvrdi/{id}")
    public ResponseEntity<Void> potvrdiStudenta(@PathVariable Long id){
        Pacijent p=registracijaService.potvrdiKorisnika(id);

        if(p != null && p.getPotvrdio() == true){
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
