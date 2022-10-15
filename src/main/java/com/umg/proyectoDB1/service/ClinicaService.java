package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Clinica;
import com.umg.proyectoDB1.repository.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clinica")
@CrossOrigin
public class ClinicaService {

    @Autowired
    ClinicaRepository clinicaRepository;

    @GetMapping(path = "/consulta")
    private List<Clinica> consulta(){return clinicaRepository.findAll();}

    @PostMapping(path = "/crea")
    private Clinica crea(@RequestBody Clinica clinica){
        return clinicaRepository.save(clinica);
    }

}
