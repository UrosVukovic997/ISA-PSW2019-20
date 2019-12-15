package com.example.ClinicalCenter.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.ClinicalCenter.model.Pacijent;
import com.example.ClinicalCenter.service.PacijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private PacijentService userService;

    // Za pristup ovoj metodi neophodno je da ulogovani korisnik ima ADMIN ulogu
    // Ukoliko nema, server ce vratiti gresku 403 Forbidden
    // Korisnik jeste autentifikovan, ali nije autorizovan da pristupi resursu
    @RequestMapping(method = GET, value = "/user/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Pacijent loadById(@PathVariable Long userId) {
        return this.userService.findOne(userId);
    }

    @RequestMapping(method = GET, value = "/user/all")
    //@PreAuthorize("hasRole('ADMIN')")
    public List<Pacijent> loadAll() {
        return this.userService.findAll();
    }

    @RequestMapping("/whoami")
    //@PreAuthorize("hasRole('USER')")
    public Pacijent user(Principal user) {
        return this.userService.findOneByE_Mail(user.getName());
    }

    @RequestMapping( method = GET, value= "/foo")
    public Map<String, String> getFoo() {
        Map<String, String> fooObj = new HashMap<>();
        fooObj.put("foo", "bar");
        return fooObj;
    }
}
