package com.example.ClinicalCenter.controller;

import com.example.ClinicalCenter.dto.AdminKcDTO;
import com.example.ClinicalCenter.model.AdminKC;
import com.example.ClinicalCenter.service.AdminKcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/adminKC")
public class AdminKcController {

    @Autowired
    private AdminKcService adminKcService;

    @PostMapping(path = "/dodaj", consumes = "application/json")
    public ResponseEntity<Void> addAdminKC(@RequestBody AdminKcDTO adminKcDTO) {

        AdminKC adminKC = new AdminKC(adminKcDTO);
        AdminKC a=adminKcService.save(adminKC);
        if(a == null){
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
        return new ResponseEntity<>((HttpStatus.CREATED));

    }

    @PostMapping(path = "/azuriraj", consumes = "application/json")
    public ResponseEntity<Void> azuriraj(@RequestBody AdminKcDTO adminKcDTO) {

        int res = adminKcService.updateAdmin(adminKcDTO.getId(),adminKcDTO.getIme(),adminKcDTO.getPrezime(),adminKcDTO.getEmail());
        if(res != 0){
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
        return new ResponseEntity<>((HttpStatus.OK));

    }

    @GetMapping(path = "/checkUsername", consumes = "application/json")
    public ResponseEntity<String> checkUsername(@RequestBody String username){
        AdminKC adminKC = adminKcService.getByUsername(username);
        if(adminKC != null)
            return new ResponseEntity<>(username,HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.FOUND);
    }
}
