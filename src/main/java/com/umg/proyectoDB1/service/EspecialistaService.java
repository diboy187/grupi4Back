package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.EspecialidadEspecialista;
import com.umg.proyectoDB1.entity.Especialista;
import com.umg.proyectoDB1.entity.Persona;
import com.umg.proyectoDB1.repository.EspecialidadEspecialistaRepository;
import com.umg.proyectoDB1.repository.EspecialistaRepository;
import com.umg.proyectoDB1.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("especialista")
@CrossOrigin
public class EspecialistaService {

    @Autowired
    EspecialistaRepository especialistaRepository;

    @Autowired
    EspecialidadEspecialistaRepository especialidadEspecialistaRepository;

    @Autowired
    PersonaRepository personaRepository;

    @GetMapping(path = "/consulta")
    private List<Especialista> consulta(){
        return especialistaRepository.findAll();
    }

    @GetMapping(path = "/consulta/{id}")
    private List<Optional<Persona>> consultaEspecialista(@PathVariable ("id") Integer id){

        List<Especialista> especialistaList = especialistaRepository.findAll();
        List<Especialista> especialistaList1 = new ArrayList<>();

        List<EspecialidadEspecialista> especialidadEspecialistas = especialidadEspecialistaRepository.findByEspecialidadIdEspecialidad(id);
        for (EspecialidadEspecialista especialidadEspecialista: especialidadEspecialistas){
            for(Especialista especialista: especialistaList){
                if(especialidadEspecialista.getEspecialistaIdEspecialista() == especialista.getIdEspecialista()){
                    especialistaList1.add(especialista);
                }
            }
        }

        List<Optional<Persona>> personaEspecialistaList = new ArrayList<>();
        for(Especialista especialista: especialistaList1){
            Optional<Persona> persona = personaRepository.findById(especialista.getPersonaIdPersona());
            personaEspecialistaList.add(persona);
        }

        return personaEspecialistaList;
    }
}
