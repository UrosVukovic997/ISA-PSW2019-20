package com.example.ClinicalCenter.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.ClinicalCenter.dto.LoginDTO;
import com.example.ClinicalCenter.model.Lekar;
import com.example.ClinicalCenter.model.Pacijent;

import com.example.ClinicalCenter.service.PacijentService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = "/logovanje", produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody LoginDTO logindto)
    {
       // System.out.println("Sifra je " + logindto.getPassword());
       // System.out.println("Username je " + logindto.getUsername());
        Pacijent user = pacijentService.findOneByE_Mail(logindto.getUsername());
        System.out.println(user.getEmail());
        if(user != null)
        {
            if(logindto.getPassword().equals(user.getPassword()))
            {
                System.out.println(user.getPassword());
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpSession session = attributes.getRequest().getSession(true);
                session.setAttribute("user", user.getUsername());
               // System.out.println(user.getPassword());
                //request.getSession().setAttribute("user", user.getEmail());
                return user.getUsername();
            }
        }
        else
        {
            return "";
        }

        return "";
    }
}
