package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Especialidad;
import com.umg.proyectoDB1.entity.Rol;
import com.umg.proyectoDB1.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("especialidad")
@CrossOrigin
public class EspecialidadService {

    @Autowired
    EspecialidadRepository especialidadRepository;

    @GetMapping(path = "/consulta")
    private List<Especialidad> consulta(){ return especialidadRepository.findAll();}

    @PostMapping(path = "/crea")
    private Especialidad crea(@RequestBody Especialidad especialidad){
        int cont = especialidadRepository.findAll().size();
        cont++;
        especialidad.setIdEspecialidad(cont);
        return especialidadRepository.save(especialidad);
    }
}

