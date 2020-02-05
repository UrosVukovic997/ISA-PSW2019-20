package com.example.ClinicalCenter.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.ClinicalCenter.dto.LoginDTO;
import com.example.ClinicalCenter.model.*;

import com.example.ClinicalCenter.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/", produces = MediaType.APPLICATION_JSON_VALUE)
public class LogovanjeController {


    @Autowired
    private PacijentService pacijentService;
    @Autowired
    private LekarService lekarService;
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private AdminKcService adminKcService;
    @Autowired
    private SestraService sestraService;

    @PostMapping(value = "/logovanje", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> login(@RequestBody LoginDTO logindto)
    {
        //System.out.println("Sifra je " + logindto.getPassword());
        //System.out.println("Username je " + logindto.getUsername());
        Pacijent user = pacijentService.findOneByE_Mail(logindto.getEmail());
        //System.out.println(user.getEmail());
        if(user != null)
        {
            if(logindto.getPassword().equals(user.getPassword()))
            {
                //System.out.println(user.getPassword());
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpSession session = attributes.getRequest().getSession(true);
                session.setAttribute("user", user.getEmail());
                // System.out.println(user.getPassword());
                //request.getSession().setAttribute("user", user.getEmail());
                List<String> returnValue = new ArrayList<>();
                returnValue.add(user.getEmail());
                returnValue.add(user.getUsername());
                return new ResponseEntity<>(returnValue, HttpStatus.OK);
            }
        }
        else
        {
            return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED);
        }

        return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED);
    }


    @PostMapping(value = "/logovanje/lekar", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> loginlekara(@RequestBody LoginDTO logindto)
    {
        //System.out.println("Sifra je " + logindto.getPassword());
        //System.out.println("Username je " + logindto.getUsername());
        Lekar user = lekarService.findByEmail(logindto.getEmail());
        //System.out.println(user.getEmail());
        if(user != null)
        {
            if(logindto.getPassword().equals(user.getLozinka()))
            {
                //System.out.println(user.getPassword());
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpSession session = attributes.getRequest().getSession(true);
                session.setAttribute("user", user.getEmail());
                // System.out.println(user.getPassword());
                //request.getSession().setAttribute("user", user.getEmail());
                List<String> returnValue = new ArrayList<>();
                returnValue.add(user.getEmail());
                returnValue.add(user.getKorIme());

                return new ResponseEntity<>(returnValue, HttpStatus.OK);
            }
        }
        else
        {
            return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED);
        }

        return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping(value = "/logovanje/mst", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> loginmst(@RequestBody LoginDTO logindto)
    {
        //System.out.println( logindto.getEmail());
        //System.out.println("Username je " + logindto.getUsername());
        Sestra user = sestraService.FindByEmail(logindto.getEmail());
        if (user == null) { System.out.println("jeste");}
        //System.out.println(user.getEmail());
        if(user != null)
        {      //System.out.println("nije");
            if(logindto.getPassword().equals(user.getLozinka()))
            {
                //System.out.println(user.getPassword());
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpSession session = attributes.getRequest().getSession(true);
                session.setAttribute("user", user.getEmail());
                // System.out.println(user.getPassword());
                //request.getSession().setAttribute("user", user.getEmail());
                List<String> returnValue = new ArrayList<>();
                returnValue.add(user.getEmail());
                returnValue.add(user.getUsername());

                return new ResponseEntity<>(returnValue, HttpStatus.OK);
            }
        }
        else
        {
            return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED);
        }

        return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping(value = "/logovanje/admin", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> loginadmin(@RequestBody LoginDTO logindto)
    {
        //System.out.println("Sifra je " + logindto.getPassword());
        //System.out.println("Username je " + logindto.getUsername());
        Administrator user = administratorService.FindByEmail(logindto.getEmail());
        //System.out.println(user.getEmail());
        if(user != null)
        {
            if(logindto.getPassword().equals(user.getLozinka()))
            {
                //System.out.println(user.getPassword());
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpSession session = attributes.getRequest().getSession(true);
                session.setAttribute("user", user.getEmail());
                // System.out.println(user.getPassword());
                //request.getSession().setAttribute("user", user.getEmail());
                List<String> returnValue = new ArrayList<>();
                returnValue.add(user.getEmail());
                returnValue.add(user.getUsername());

                return new ResponseEntity<>(returnValue, HttpStatus.OK);
            }
        }
        else
        {
            return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED);
        }

        return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping(value = "/logovanje/adminkc", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> loginadminkc(@RequestBody LoginDTO logindto)
    {
        //System.out.println("Sifra je " + logindto.getPassword());
        //System.out.println("Username je " + logindto.getUsername());
        AdminKC user = adminKcService.getByEmail(logindto.getEmail());
        //System.out.println(user.getEmail());
        if(user != null)
        {
            if(logindto.getPassword().equals(user.getLozinka()))
            {
                //System.out.println(user.getPassword());
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpSession session = attributes.getRequest().getSession(true);
                session.setAttribute("user", user.getEmail());
                // System.out.println(user.getPassword());
                //request.getSession().setAttribute("user", user.getEmail());
                List<String> returnValue = new ArrayList<>();
                returnValue.add(user.getEmail());
                returnValue.add(user.getUsername());

                return new ResponseEntity<>(returnValue, HttpStatus.OK);
            }
        }
        else
        {
            return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED);
        }

        return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED);
    }
}
