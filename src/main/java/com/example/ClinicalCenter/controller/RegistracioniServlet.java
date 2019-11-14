package com.example.ClinicalCenter.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/regServlet")
public class RegistracioniServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // code to process the form...
        String ime = request.getParameter("ime");
        String prezime = request.getParameter("prezime");
        String e_mail = request.getParameter("email");
        String lozinka = request.getParameter("lozinka");
        String pot_lozinka = request.getParameter("potvrda_lozinke");
        String jbo = request.getParameter("jbo");
        String adresa = request.getParameter("adresa");
        String grad = request.getParameter("grad");
        String drzava = request.getParameter("drzava");
        String br = request.getParameter("broj_telefona");

    }
}
