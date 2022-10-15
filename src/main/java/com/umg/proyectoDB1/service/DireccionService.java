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
    private List<Direccion> consulta(){
        return direccionRepository.findAll() ;
    }

    @PostMapping(path = "/crea")
    private Direccion crea(@RequestBody Direccion direccion){
        if (direccion != null){
            List<Direccion> direccionList = direccionRepository.findAll();
            int contador = direccionList.size();
            contador++;
            direccion.setIdDireccion(contador);
            direccionRepository.save(direccion);
            return direccion;
        }else {
            return direccion = null;
        }
    }


}
