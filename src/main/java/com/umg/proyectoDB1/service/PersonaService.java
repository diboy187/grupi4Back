package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Cliente;
import com.umg.proyectoDB1.entity.Especialista;
import com.umg.proyectoDB1.entity.Persona;
import com.umg.proyectoDB1.entity.Usuario;
import com.umg.proyectoDB1.repository.ClienteRepository;
import com.umg.proyectoDB1.repository.EspecialistaRepository;
import com.umg.proyectoDB1.repository.PersonaRepository;
import com.umg.proyectoDB1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Autowired
    EspecialistaRepository especialistaRepository;


    @GetMapping(path = "/consulta")
    private List<Persona> consulta(){ return personaRepository.findAll();
    }

    @GetMapping(path = "/consulta/{ID}")
    private Optional<Persona> busqueda(@PathVariable ("ID") int Id){
        return personaRepository.findById(Id);
    }


    @GetMapping(path ="/consultaCliente")
    private ArrayList<Optional<Persona>> consultaCliente(){
        List<Cliente> clienteList = clienteRepository.findAll();
        ArrayList<Optional<Persona>> personas = new ArrayList<>();
        for (Cliente cliente:clienteList) {
            Optional<Persona> personaListTemp = personaRepository.findByIdPersona(cliente.getPersonaIdPersona());
            personas.add(personaListTemp);
        }
        return personas;
    }

    @GetMapping(path ="/consultaEspecialista")
    private ArrayList<Optional<Persona>> consultaEspecialista(){
        List<Especialista> especialistaList = especialistaRepository.findAll();
        ArrayList<Optional<Persona>> personas = new ArrayList<>();
        for (Especialista especialista: especialistaList) {
            Optional<Persona> personaListTemp = personaRepository.findByIdPersona(especialista.getPersonaIdPersona());
            personas.add(personaListTemp);
        }
        return personas;
    }

    @GetMapping(path = "/Especialista")
    private List<Especialista> consultaE(){
        return especialistaRepository.findAll();
    }

    @GetMapping(path = "/buscaIdentidad/{tipoIdentidad}/{identidad}")
    private Optional<Persona> buscaIdentidad(@PathVariable ("tipoIdentidad") int tipoIdentidad, @PathVariable("identidad") String identidad){
        return personaRepository.findByTipoIdentidadIdTipoIdentidadAndIdentidad(tipoIdentidad, identidad);
    }

    @DeleteMapping(path = "/eliminaCliente")
    private Optional<Usuario> eliminaCliente(){

        return null;
    }


    @PostMapping(path = "/creaCliente")
    private Optional<Usuario>  crea(@RequestBody Persona persona){
        if (persona.getIdPersona() == null){
            List<Persona> personaList = personaRepository.findAll();
            int contador = personaList.size() + 1;
            persona.setIdPersona(contador);
            creaPersona(persona);
        }else{
            creaPersona(persona);
        }
        //creacion cliente
        CreaCliente(persona);
        //creacion de usuario
        int usuario = 0;
        usuario = CreaUsuario(persona);
        //return persona;
        return buscaUsuario(usuario);
    }

    @PostMapping(path = "/creaEspecialista")
    private Optional<Usuario> creaE(@RequestBody Persona persona){
        if(persona.getIdPersona() == null){
            List<Persona> personaList = personaRepository.findAll();
            int contador = personaList.size() + 1;
            persona.setIdPersona(contador);
            creaPersona(persona);
        }else {
            creaPersona(persona);
        }
        CreaEspecialista(persona);
        int usuario = 0;
        usuario = CreaUsuario(persona);
        return buscaUsuario(usuario);
    }


    private void creaPersona(Persona persona){
        personaRepository.save(persona);
    }

    private void CreaCliente(Persona persona){
            List<Cliente> clienteList = clienteRepository.findAll();
            int contador =  clienteList.size() + 1;
            Cliente cliente = new Cliente();
            cliente.setIdCliente(contador);
            cliente.setPersonaIdPersona(persona.getIdPersona());
            cliente.setAntiguedadMeses(String.valueOf(LocalDateTime.now()));
            clienteRepository.save(cliente);
    }

    private void CreaEspecialista(Persona persona){
            List<Especialista> especialistaList = especialistaRepository.findAll();
            int contador = especialistaList.size() + 1;
            Especialista especialista = new Especialista();
            especialista.setIdEspecialista(contador);
            especialista.setPersonaIdPersona(persona.getIdPersona());
            especialista.setEstadoIdEstado(1);
            especialistaRepository.save(especialista);
    }


    private int CreaUsuario(Persona persona){
        List<Usuario> usuarioList = usuarioRepository.findAll();
        int contador = usuarioList.size() ;
        contador++;
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(contador);
        usuario.setUsuario(String.valueOf(persona.getNombre().charAt(0)+persona.getApellido()+contador).toUpperCase(Locale.ROOT));
        usuario.setPassword(new MD5().convierte("1"));
        usuario.setPersonaIdPersona(persona.getIdPersona());
        usuarioRepository.save(usuario);
        return usuario.getIdUsuario();
    }

    private Optional<Usuario> buscaUsuario(int idUsuario){
       return usuarioRepository.findById(idUsuario);
    }



}
