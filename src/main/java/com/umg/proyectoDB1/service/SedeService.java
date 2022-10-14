package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Sede;
import com.umg.proyectoDB1.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sede")
@CrossOrigin
public class SedeService {

    @Autowired
    SedeRepository sedeRepository;

    @GetMapping(path = "/consulta")
    private List<Sede> consulta(){return sedeRepository.findAll();}

    @PostMapping(path = "/crea")
    private Sede crea(@RequestBody Sede sede){
        return sedeRepository.save(sede);
    }


}
