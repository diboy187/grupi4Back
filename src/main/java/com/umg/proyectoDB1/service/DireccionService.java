package com.umg.proyectoDB1.service;


import com.umg.proyectoDB1.entity.Direccion;
import com.umg.proyectoDB1.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/crea")
    private String crea(@RequestBody Direccion direccion){
        if (direccion != null){
           direccionRepository.save(direccion);
            return "Creado exitosamente";
        }else {
            return "Error al crear la direccion";
        }

    }
}
