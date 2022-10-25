package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Rol;
import com.umg.proyectoDB1.entity.TipoIdentidad;
import com.umg.proyectoDB1.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rol")
@CrossOrigin
public class RolService {
    @Autowired
    RolRepository rolRepository;

    @GetMapping(path = "/consulta")
    private List<Rol> consulta(){
        return rolRepository.findAll();
    }


    @PostMapping(path = "/crea")
    private Rol crea(@RequestBody Rol tipoIdentidad){
        int cont = rolRepository.findAll().size();
        cont++;
        tipoIdentidad.setIdRol(cont);
        return rolRepository.save(tipoIdentidad);
    }
}
