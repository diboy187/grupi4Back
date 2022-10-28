package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.*;
import com.umg.proyectoDB1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/login")
@CrossOrigin

public class LoginService {

    public int estadoError = 1;
    public int estadoOk = 0;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    EstadoRepository estadoRepository;
    @Autowired
    HistorialRepository historialRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    PersonaRepository personaRepository;

    //login
    @PostMapping(path = "/autenticacion")
    private Login Authentication(@RequestBody Usuario usuario) {
        System.out.println("Datos del login recibiendo .... " + "user -> "+usuario.getUsuario() );
        if (usuario.getUsuario() == null || usuario.getPassword() == null || usuario.getUsuario().isEmpty() || usuario.getPassword().isEmpty()) {
            //si los parametros son erroneos
            Login login = new Login();
            login.setCodError(estadoError);
            login.setMensaje("Parametros invalidos");
            return login;
        } else {
            usuario.setPassword(new MD5().convierte(usuario.getPassword()));
            int longitud = usuarioRepository.findByUsuarioAndPassword(usuario.getUsuario(), usuario.getPassword()).size();
            if (longitud > 0) {
                Optional<Usuario> datosUsuario = usuarioRepository.findByUsuario(usuario.getUsuario());
                int estadoUsuario = datosUsuario.get().getIdUsuario();
                int estadoNew = validaEstado(estadoUsuario, 1);
                if (estadoNew == 1) {
                    Login login = new Login();
                    login.setIdCliente(buscaCliente(datosUsuario.get().getPersonaIdPersona()));
                    login.setCodError(estadoOk);
                    login.setMensaje("¡bienvenido!");
                    login.setUsuario(usuario.getUsuario());
                    login.setPassword(usuario.getPassword());
                    login.setEstado(EstadoValor(estadoNew));
                    login.setRol(RolValor(datosUsuario.get().getIdUsuario(), 1));
                    return login;
                } else {
                    Login login = new Login();
                    login.setCodError(estadoError);
                    login.setMensaje("¡Estado no valido!");
                    return login;
                }
            } else {
                Login login = new Login();
                login.setCodError(estadoError);
                login.setEstado("¡Usuario  o Contraseña Erronea!");
                login.setPassword(usuario.getPassword());
                return login;
            }
        }
    }


    //    busca cliente
    public int buscaCliente(int id){
        Optional<Persona> persona = personaRepository.findById(id);

        if(!persona.get().getClienteList().isEmpty()){
            return persona.get().getClienteList().get(0).getIdCliente();
        }else{
            return -1;
        }
    }

    //devuelve el valor del Estado
    public String EstadoValor(int idEstado) {
        Optional<Estado> estados = estadoRepository.findById(idEstado);
        return estados.get().getNombreEstado();
    }

    //encuentra el historial
    public Optional<Historial> historial(int idUsuario) {
        Optional<Historial> historial = historialRepository.findById(idUsuario);
        return historial;
    }

    //devuelve el valor del Rol
    public int RolValor(int idUsuario, int estado) {
        int valor = buscaEstado(estado, idUsuario);
        Optional<Historial> rol = historialRepository.findById(valor);
        return rol.get().getRolIdRol();
    }

    public int validaEstado(int usuario, int estado) {
        int valor = buscaEstado(estado, usuario);
        if (valor == 0) {
            return 0;
        } else {
            return historial(valor).get().getEstadoIdEstado();
        }

    }

    public int buscaEstado(int estado, int idusuario) {
        List<Historial> historial = historialRepository.findHistorialByEstadoIdEstadoAndUsuarioIdUsuarioOrderByIdHistorial(estado, idusuario);
        int longitud = historial.size();
        int cont = 0;

        if (longitud == 0) {
            return cont;
        }
        for (Historial historia : historial) {
            if (historia.getIdHistorial() > cont) {
                cont = historia.getIdHistorial();
            } else {
                cont = historia.getIdHistorial();
                return cont;
            }

            return cont;
        }
        return cont;
    }


}