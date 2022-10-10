package com.umg.proyectoDB1.service;


import com.umg.proyectoDB1.entity.Direccion;
import com.umg.proyectoDB1.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("direccion")
@CrossOrigin
public class DireccionService {

    @Autowired
    DireccionRepository direccionRepository;

    @GetMapping(path = "/consulta")
    private List<Direccion> find(){
        return direccionRepository.findAll() ;
    }
}
