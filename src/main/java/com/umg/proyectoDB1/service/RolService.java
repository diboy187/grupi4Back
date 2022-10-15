package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Rol;
import com.umg.proyectoDB1.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Rol")
@CrossOrigin
public class RolService {
    @Autowired
    RolRepository rolRepository;

    @GetMapping(path = "/consulta")
    private List<Rol> consulta(){
        return rolRepository.findAll();
    }
}
