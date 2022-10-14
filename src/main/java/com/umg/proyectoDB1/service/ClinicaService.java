package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Cliente;
import com.umg.proyectoDB1.entity.Clinica;
import com.umg.proyectoDB1.entity.Persona;
import com.umg.proyectoDB1.repository.ClienteRepository;
import com.umg.proyectoDB1.repository.ClinicaRepository;
import oracle.ons.Cli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("clinica")
@CrossOrigin
public class ClinicaService {

    @Autowired
    ClinicaRepository clinicaRepository;


    @GetMapping(path = "/consulta")
    private List<Clinica> find(){return clinicaRepository.findAll();}

    @PostMapping(path = "/crea")
    private Clinica crea(@RequestBody Clinica clinica){
        return clinicaRepository.save(clinica);
    }



}
