package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.*;
import com.umg.proyectoDB1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.*;

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

    @Autowired
    HistorialRepository historialRepository;

    public int estadoError = 1;
    public int estadoOk = 0;

    @GetMapping(path = "/consulta")
    private List<Persona> consulta(){ return personaRepository.findAll();
    }

    @GetMapping(path = "/consulta/{ID}")
    private Optional<Persona> busqueda(@PathVariable ("ID") int Id){
        return personaRepository.findById(Id);
    }

    @GetMapping(path = "consultaNit/{nit}")
    private Optional<Persona> busquedaPorNit(@PathVariable("nit")String nit){
        return personaRepository.findByNit(nit);
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

    @GetMapping(path = "/especialista")
    private List<Especialista> consultaE(){
        return especialistaRepository.findAll();
    }

    @GetMapping(path = "/buscaIdentidad/{tipoIdentidad}/{identidad}")
    private Optional<Persona> buscaIdentidad(@PathVariable ("tipoIdentidad") int tipoIdentidad, @PathVariable("identidad") String identidad){
        System.out.println(tipoIdentidad);
        System.out.println(identidad);
        return personaRepository.findByTipoIdentidadIdTipoIdentidadAndIdentidad(tipoIdentidad, identidad);
    }

    @PostMapping(path = "/creaCliente")
    private Login  crea(@RequestBody Persona persona){
        if (persona.getIdPersona() == null){
            List<Persona> personaList = personaRepository.findAll();
            int contador = personaList.size() + 1;
            persona.setIdPersona(contador);
            Boolean pasa = ValidaNitDpi(persona);
            if( pasa){
                creaPersona(persona);
            }else{
                pasa= false;
                Login login = new Login();
                login.setCodError(estadoError);
                login.setMensaje("Cliente con dpi o nit ya existe");
                return login;
            }
        }else{
            Boolean pasa = ValidaNitDpi(persona);
            if( pasa){
                creaPersona(persona);
            }else{
                pasa= false;
                Login login = new Login();
                login.setCodError(estadoError);
                login.setMensaje("Cliente con dpi o nit ya existe");
                return login;
            }
        }
        //creacion cliente
        CreaCliente(persona);
        //creacion de usuario
        int usuario = 0;
        usuario = CreaUsuario(persona);
        //return persona;
        buscaUsuario(usuario);
        Login usuarioCreado = new Login();
        usuarioCreado.setUsuario(buscaUsuario(usuario).get().getUsuario());
        creaHistorial(usuarioCreado);
        usuarioCreado.setMensaje("Creado exitosamente");
        usuarioCreado.setRol(1);
        usuarioCreado.setCodError(estadoOk);
        usuarioCreado.setEstado("Activo");
        return usuarioCreado;
    }

    private void creaHistorial(Login usuario){
        Historial historial = new Historial();
        List<Historial> historialList = historialRepository.findAll();
        int contador = historialList.size() + 1;
        historial.setIdHistorial(contador);
        historial.setEstadoIdEstado(1);
        historial.setFechaCambio(LocalDateTime.now());
        historial.setRolIdRol(2);
        historial.setUsuarioIdUsuario( buscaUsuarioId(usuario.getUsuario()));
        historialRepository.save(historial);

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
        buscaUsuario(usuario);
        Login usuarioCreado = new Login();
        usuarioCreado.setUsuario(buscaUsuario(usuario).get().getUsuario());
        creaHistorial(usuarioCreado);
        return buscaUsuario(usuario);
    }




    private void creaPersona(Persona persona){
        personaRepository.save(persona);
    }

    private boolean ValidaNitDpi(Persona persona){
        List<Persona> personaList = personaRepository.findAll();
        String  nit = persona.getNit();
        int tipoIdentidad = persona.getTipoIdentidadIdTipoIdentidad();
        String  identidad = persona.getIdentidad();
        for (Persona personas:personaList
             ) {
          if(personas.getNit().equals(nit) || personas.getTipoIdentidadIdTipoIdentidad()==tipoIdentidad && personas.getIdentidad().equals(identidad) ){
               return false;
          }
         else{
              return true;
          }
        }
        return true;
    }

    private void CreaCliente(Persona persona){
            List<Cliente> clienteList = clienteRepository.findAll();
            int contador =  clienteList.size() + 1;
            Cliente cliente = new Cliente();
            cliente.setIdCliente(contador);
            cliente.setPersonaIdPersona(persona.getIdPersona());
            cliente.setFechaCreacion(LocalDateTime.now());
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

    private int buscaUsuarioId(String usuario){
        return usuarioRepository.findByUsuario(usuario).get().getIdUsuario();
    }




}
