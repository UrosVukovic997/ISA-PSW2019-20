package com.example.ClinicalCenter.service;

import com.example.ClinicalCenter.dto.LekarDTO;
import com.example.ClinicalCenter.dto.OdsustvoOdmorDTO;
import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.model.OdsustvoOdmor;
import com.example.ClinicalCenter.repository.LekarRepository;
import com.example.ClinicalCenter.repository.OdsustvoOdmorRepository;
import org.springframework.stereotype.Service;

@Service
public class OdsustvoOdmorService {

    private LekarRepository lekarRepository;
    private OdsustvoOdmorRepository odsustvoOdmorRepositiry;

    public OdsustvoOdmor zahtev(OdsustvoOdmorDTO odsustvoOdmorDTO, Lekar lekar) {

        OdsustvoOdmor odsustvoOdmor = new OdsustvoOdmor(odsustvoOdmorDTO.getPocetak(),odsustvoOdmorDTO.getKraj(),odsustvoOdmorDTO.getGodisnji(),odsustvoOdmorDTO.getOdsustvo());
        odsustvoOdmor.setLekar(lekar);
        lekar.getOdsustvoOdmori().add(odsustvoOdmor);

        return this.odsustvoOdmorRepositiry.save(odsustvoOdmor);
    }
}
