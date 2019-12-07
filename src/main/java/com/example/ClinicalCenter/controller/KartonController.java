package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.dto.KartonDTO;
import com.example.ClinicalCenter.model.Karton;
import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.service.KartonService;
import com.example.ClinicalCenter.service.LekarService;
import com.example.ClinicalCenter.service.PacijentService;
import com.example.ClinicalCenter.service.SestraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
//// Nikola grana
public class KartonController {

        @Autowired
        private LekarService lekarService;

        @Autowired
        private PacijentService pacijentService;

        @Autowired
        private SestraService sestraService;

        @Autowired
        private KartonService kartonService;


        @PostMapping(consumes = "application/json")
        public ResponseEntity<KartonDTO> createKarton(@RequestBody KartonDTO kartonDTO, String pacijent) {

                // Kreiranje kartona sa novim vrednostima polja
                Karton karton = new Karton();
                karton.setBroj(kartonDTO.getBroj());
                karton.setDijagnoze(kartonDTO.getDijagnoze());
                karton.setPregledi(kartonDTO.getPregledi());

                // Proveravamo da li je E_mail odgovarajuci (jedinstveni podatak pacijenta)
                Pacijent p = pacijentService.findOneByE_Mail(pacijent);
                if (p == null) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }

                karton.setPacijent(p);

                // Vracamo odgovarajuci odgovor
                return new ResponseEntity<>(HttpStatus.OK);

        }

        @PutMapping(consumes = "application/json")
        public ResponseEntity<KartonDTO> updateKarton(@RequestBody KartonDTO kartonDTO, String pacijent) {

                // Pacijent mora postojati
                Pacijent p = pacijentService.findOneByE_Mail(pacijent);
                if (p == null) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }

                // Karton mora postojati
                Karton karton = kartonService.findOne(kartonDTO.getId());
                if (karton == null) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }

                // Odobravamo samo promenu dijagnoza i pregleda
                karton.setDijagnoze(kartonDTO.getDijagnoze());
                karton.setPregledi(kartonDTO.getPregledi());

                // Cuvamo azuriran karton
                karton = kartonService.save(karton);

                // Vracamo odgovarajuci odgovor
                return new ResponseEntity<>(new KartonDTO(karton), HttpStatus.OK);
        }

        @DeleteMapping(value = "/{id}")
        public ResponseEntity<Void> deleteKarton(@PathVariable Long id) {

                // Pronalazi KARTON preko ID
                Karton karton = kartonService.findOne(id);

                // Proverava da li KARTON sa tim ID postoji, ako postoji brise ga
                if (karton != null) {
                    kartonService.remove(id);
                    return new ResponseEntity<>(HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
        }

}
