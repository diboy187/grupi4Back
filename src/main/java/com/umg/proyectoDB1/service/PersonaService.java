package com.umg.proyectoDB1.service;


import com.umg.proyectoDB1.entity.Cliente;
import com.umg.proyectoDB1.entity.Persona;
import com.umg.proyectoDB1.entity.Usuario;
import com.umg.proyectoDB1.repository.ClienteRepository;
import com.umg.proyectoDB1.repository.PersonaRepository;
import com.umg.proyectoDB1.repository.UsuarioRepository;
import org.apache.catalina.valves.rewrite.InternalRewriteMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("persona")
@CrossOrigin
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ClienteRepository clienteRepository;


    @GetMapping(path = "/consulta")
    private List<Persona> find(){ return personaRepository.findAll();
    }

    @PostMapping(path = "/crea")
    private String  crea(@RequestBody Persona persona){
        List<Persona> personaList = personaRepository.findAll();
        int contador = personaList.size() + 1;
        persona.setIdPersona(contador);
        personaRepository.save(persona);
        //creacion cliente
        CreaCliente(persona);
        //creacion de usuario
        String usuario = CreaUsuario(persona);

        //return persona;
        return "Usuario creado exitosamente  --->  " + usuario;
    }


    public void CreaCliente(Persona persona){
        System.out.println("persona " + persona.getNombre());
        List<Cliente> clienteList = clienteRepository.findAll();
        int contador =  clienteList.size() + 1;
        Cliente cliente = new Cliente();
        cliente.setIdCliente(contador);
        cliente.setPersonaIdPersona(persona.getIdPersona());
        cliente.setAntiguedadMeses(String.valueOf(LocalDateTime.now()));
        clienteRepository.save(cliente);
    }



    public String CreaUsuario(Persona persona){
        List<Usuario> usuarioList = usuarioRepository.findAll();
        int contador = usuarioList.size() + 1;
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(contador);
        usuario.setUsuario(String.valueOf(persona.getNombre().charAt(0)+persona.getApellido()+1).toUpperCase(Locale.ROOT));
        usuario.setPassword(new MD5().convierte("1"));
        usuario.setPersonaIdPersona(persona.getIdPersona());
        usuarioRepository.save(usuario);
        return usuario.getUsuario();
    }



}
