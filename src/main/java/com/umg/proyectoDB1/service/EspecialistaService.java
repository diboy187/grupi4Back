package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Especialista;
import com.umg.proyectoDB1.repository.EspecialistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("especialista")
@CrossOrigin
public class EspecialistaService {

    @Autowired
    EspecialistaRepository especialistaRepository;

    @GetMapping(path = "/consulta")
    private List<Especialista> consulta(){
        return especialistaRepository.findAll();
    }

}
