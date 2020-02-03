package com.example.ClinicalCenter.controller;


import com.example.ClinicalCenter.dto.LekarDTO;
import com.example.ClinicalCenter.dto.OdsustvoOdmorDTO;
import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.model.OdsustvoOdmor;
import com.example.ClinicalCenter.service.LekarService;
import com.example.ClinicalCenter.service.OdsustvoOdmorService;
import com.example.ClinicalCenter.service.PacijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/lekar")
public class OdsustvoOdmorController {
    @Autowired
    private OdsustvoOdmorService odsustvoOdmorService;

    @Autowired
    private LekarService lekarService;

    @PostMapping(path = "/zahtevOdsGod/{id}")
    public ResponseEntity<OdsustvoOdmorDTO> zahtevOdsustvo(@PathVariable Long id, @RequestBody OdsustvoOdmorDTO odsustvoOdmorDTO) {

        System.out.println(odsustvoOdmorDTO.getPocetak());
        System.out.println(odsustvoOdmorDTO.getKraj());

        Lekar lekar = lekarService.findOne(id);

        OdsustvoOdmor odsustvoOdmor = odsustvoOdmorService.zahtev(odsustvoOdmorDTO, lekar);

        return new ResponseEntity<>(new OdsustvoOdmorDTO(odsustvoOdmor), HttpStatus.OK);
    }

}
