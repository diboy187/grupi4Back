package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Municipio;
import com.umg.proyectoDB1.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("municipio")
@CrossOrigin
public class MunicipioService {

    @Autowired
    MunicipioRepository municipioRepository;

    @GetMapping (path = "/consulta")
    private List<Municipio> consulta(){ return municipioRepository.findAll();}

    @PostMapping(path = "/crea")
    private Municipio crea(@RequestBody Municipio municipio){
        return municipioRepository.save(municipio);
    }

    @GetMapping(path = "/consulta/{id}")
    private List<Municipio> consultaMunicipio(@PathVariable ("id") Integer id){
        return municipioRepository.findByDepartamentoIdDepartamento(id);
    }
}
