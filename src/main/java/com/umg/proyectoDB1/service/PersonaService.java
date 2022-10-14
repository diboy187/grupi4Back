package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Cliente;
import com.umg.proyectoDB1.entity.Persona;
import com.umg.proyectoDB1.entity.Usuario;
import com.umg.proyectoDB1.repository.ClienteRepository;
import com.umg.proyectoDB1.repository.PersonaRepository;
import com.umg.proyectoDB1.repository.UsuarioRepository;
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
    private List<Persona> consulta(){ return personaRepository.findAll();
    }

    @GetMapping(path = "/consulta/{ID}")
    private Optional<Persona> busqueda(@PathVariable ("ID") int Id){
        return personaRepository.findById(Id);
    }



    @PostMapping(path = "/crea")
    private String  crea(@RequestBody Persona persona){
        if (persona.getIdPersona() == null){
            List<Persona> personaList = personaRepository.findAll();
            int contador = personaList.size() + 1;
            persona.setIdPersona(contador);
            creaPersonaCliente(persona);
        }else{
            creaPersonaCliente(persona);
        }
        //creacion cliente
        CreaCliente(persona);
        //creacion de usuario
        String usuario = "";
        usuario = CreaUsuario(persona);

        //return persona;
        return usuario;
    }




    public void creaPersonaCliente(Persona persona){
        personaRepository.save(persona);
    }

    public void CreaCliente(Persona persona){
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


    public void CreaEspecialista(Persona persona){

    }

}
