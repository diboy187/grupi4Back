package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Clinica;
import com.umg.proyectoDB1.repository.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clinica")
@CrossOrigin
public class ClinicaService {

    @Autowired
    ClinicaRepository clinicaRepository;

    @GetMapping(path = "/consulta")
    private List<Clinica> find(){return clinicaRepository.findAll();}
}
