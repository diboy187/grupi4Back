package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Especialidad;
import com.umg.proyectoDB1.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Especialidad")
@CrossOrigin
public class EspecialidadService {

    @Autowired
    EspecialidadRepository especialidadRepository;

    @GetMapping(path = "/consulta")
    private List<Especialidad> find(){ return especialidadRepository.findAll();}
}

