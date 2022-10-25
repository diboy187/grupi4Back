package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.TipoIdentidad;
import com.umg.proyectoDB1.repository.TipoIdentidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("tipoIdentidad")
@CrossOrigin
public class TipoIdentidadService {

    @Autowired
    TipoIdentidadRepository tipoIdentidadRepository;

    @GetMapping(path = "/consulta")
    private List<TipoIdentidad> consulta(){
        return tipoIdentidadRepository.findAll();
    }


}
