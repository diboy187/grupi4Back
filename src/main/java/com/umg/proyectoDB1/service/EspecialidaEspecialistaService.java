package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.*;
import com.umg.proyectoDB1.repository.EspecialidadEspecialistaRepository;
import com.umg.proyectoDB1.repository.EspecialistaRepository;
import com.umg.proyectoDB1.repository.PersonaRepository;
import com.umg.proyectoDB1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("especialidadEspecialista")
@CrossOrigin
public class EspecialidaEspecialistaService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    EspecialistaRepository especialistaRepository;

    @Autowired
    EspecialidadEspecialistaRepository especialidadEspecialistaRepository;

    @PostMapping(path = "/crea/{usuario}")
    private Optional<Especialista> crea(@PathVariable("usuario") String usuario, @RequestBody List<Especialidad> especialidadList){

        Optional<Usuario> usuarioBuscado = usuarioRepository.findByUsuario(usuario);
        Optional<Persona> persona = personaRepository.findByIdPersona(usuarioBuscado.get().getPersonaIdPersona());
        Optional<Especialista> especialista = especialistaRepository.findByPersonaIdPersona(persona.get().getIdPersona());

        int cont = especialidadEspecialistaRepository.findAll().size();
        for(Especialidad especialidad : especialidadList){
            cont++;
            EspecialidadEspecialista especialidadEspecialista = new EspecialidadEspecialista();
            especialidadEspecialista.setIdespecialidadEspecialista(cont);
            especialidadEspecialista.setEspecialidadIdEspecialidad(especialidad.getIdEspecialidad());
            especialidadEspecialista.setEspecialistaIdEspecialista(especialista.get().getIdEspecialista());
            especialidadEspecialistaRepository.save(especialidadEspecialista);
        }

        return especialistaRepository.findByPersonaIdPersona(persona.get().getIdPersona());

    }
}
