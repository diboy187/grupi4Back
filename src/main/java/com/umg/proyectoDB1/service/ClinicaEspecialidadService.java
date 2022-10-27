package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.ClinicaEspecialidad;
import com.umg.proyectoDB1.repository.ClinicaEspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clinicaEspecialidad")
@CrossOrigin
public class ClinicaEspecialidadService {

    @Autowired
    ClinicaEspecialidadRepository clinicaEspecialidadRepository;

    @GetMapping(path = "/consulta/{id}")
    private List<ClinicaEspecialidad> consultaEspecialidad(@PathVariable("id") Integer id){
        return clinicaEspecialidadRepository.findByClinicaIdClinica(id);
    }

    @PostMapping(path = "crea")
    private ClinicaEspecialidad crea(@RequestBody ClinicaEspecialidad clinicaEspecialidad){
        int cont = clinicaEspecialidadRepository.findAll().size();
        cont++;
        clinicaEspecialidad.setIdClinicaEspecialidad(cont);
        return clinicaEspecialidadRepository.save(clinicaEspecialidad);
    }
}
