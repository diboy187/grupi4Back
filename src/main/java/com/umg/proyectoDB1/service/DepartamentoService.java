package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Departamento;
import com.umg.proyectoDB1.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("departamento")
@CrossOrigin
public class DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    @GetMapping(path = "/consulta")
    private List<Departamento> find(){
        return departamentoRepository.findAll() ;
    }



}
