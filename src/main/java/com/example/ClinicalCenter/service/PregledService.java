package com.example.ClinicalCenter.service;
import com.example.ClinicalCenter.dto.PregledDTO;
import com.example.ClinicalCenter.model.*;
import com.example.ClinicalCenter.repository.LekRepository;
import com.example.ClinicalCenter.repository.PregledRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class PregledService {

    @Autowired
    private PregledRepository pregledRepository;

    @Autowired
    private PacijentService pacijentService;

    @Autowired
    private LekarService lekarService;

    public List<Pregled> findAll(){return pregledRepository.findAll();}

    public Pregled add(Pregled pregled){return pregledRepository.save(pregled);}

    public void deleteById(Long id){ pregledRepository.deleteById(id);}

    public void zakaziPregled(PregledDTO pregledDTO, Long id){

        Pregled pregled = new Pregled();
        pregled.setDrzavljanstvo(pregledDTO.getDrzavljanstvo());
        pregled.setEmail(pregledDTO.getEmail());
        pregled.setGrad(pregledDTO.getGrad());
        pregled.setHitnost(pregledDTO.getHitnost());
        pregled.setIme_pacijenta(pregledDTO.getImePacijenta());
        pregled.setPrezime_pacijenta(pregledDTO.getPrezimePacijenta());
        pregled.setPocetak(pregledDTO.getKraj());
        pregled.setKraj(pregledDTO.getKraj());
        pregled.setJbo(pregledDTO.getJbo());
        pregled.setObrisan(false);
        pregled.setObavljen(false);

        Lekar lekar = this.lekarService.findOne(id);
        pregled.setLekar(lekar);
        Pacijent pacijent = this.pacijentService.findOneByE_Mail(pregledDTO.getEmail());
        pregled.setPacijent(pacijent);

        save(pregled);

    }
    public Pregled save(Pregled pregled) {
        return pregledRepository.save(pregled);
    }

    public List<Pregled> findByJbo( int jbo ){return pregledRepository.findByJbo( jbo );}

}
