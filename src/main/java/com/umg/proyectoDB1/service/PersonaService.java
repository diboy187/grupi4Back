package com.umg.proyectoDB1.service;


import com.umg.proyectoDB1.entity.Persona;
import com.umg.proyectoDB1.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("persona")
@CrossOrigin
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @GetMapping(path = "/consulta")
    private List<Persona> find(){ return personaRepository.findAll();}
}
