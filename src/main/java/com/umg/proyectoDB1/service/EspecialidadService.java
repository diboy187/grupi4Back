package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Especialidad;
import com.umg.proyectoDB1.entity.Rol;
import com.umg.proyectoDB1.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        int id = especialidadRepository.findAll().size();
        id++;
        especialidad.setIdEspecialidad(id);
        return especialidadRepository.save(especialidad);
    }
    @PostMapping(path = "/actualizar")
    private Especialidad actualiza(@RequestBody Especialidad especialidad){

//        Optional<Especialidad> es = especialidadRepository.findByEspecialidad(especialidad.getEspecialidad());
//        especialidad.setIdEspecialidad(es.get().getIdEspecialidad());
        System.out.println(especialidad.getEspecialidad());
        System.out.println(especialidad.getIdEspecialidad());
       return especialidadRepository.save(especialidad);
//return especialidad;
    }

}

