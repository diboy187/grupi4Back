package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Sede;
import com.umg.proyectoDB1.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sede")
@CrossOrigin
public class SedeService {

    @Autowired
    SedeRepository sedeRepository;

    @GetMapping(path = "/consulta")
    private List<Sede> find(){return sedeRepository.findAll();}

}
