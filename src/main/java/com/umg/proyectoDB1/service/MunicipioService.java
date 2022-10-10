package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Municipio;
import com.umg.proyectoDB1.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("municipio")
@CrossOrigin
public class MunicipioService {

    @Autowired
    MunicipioRepository municipioRepository;

    @GetMapping (path = "/consulta")
    private List<Municipio> find(){ return municipioRepository.findAll();}
}
