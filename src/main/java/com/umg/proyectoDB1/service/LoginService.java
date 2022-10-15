package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Historial;
import com.umg.proyectoDB1.entity.Horario;
import com.umg.proyectoDB1.entity.Usuario;
import com.umg.proyectoDB1.repository.EstadoRepository;
import com.umg.proyectoDB1.repository.HistorialRepository;
import com.umg.proyectoDB1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/login")
@CrossOrigin

public class LoginService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    HistorialRepository historialRepository;

    //login
    @PostMapping(path = "/autenticacion")
    private Usuario  login(@RequestBody Usuario usuario) {
        int longitud = usuarioRepository.findByUsuarioAndPassword(usuario.getUsuario(), usuario.getPassword()).size();
        if (usuario.getUsuario() == null || usuario.getPassword() == null || usuario.getUsuario().isEmpty() || usuario.getPassword().isEmpty()) {
            return usuario = null;
        } else if (usuario.getUsuario().equals("admin") && usuario.getPassword().equals("21232f297a57a5a743894a0e4a801fc3")) {
            return usuario ;
        } else if (longitud > 0) {
            Optional<Usuario> usuariotemporal = usuarioRepository.findByUsuario(usuario.getUsuario());
            int estadoUsuario = usuariotemporal.get().getIdUsuario();
            int estado = validaEstado(estadoUsuario, 1);
            if (estado == 1) {
                usuario.setIdUsuario(usuariotemporal.get().getIdUsuario());
                usuario.setPersonaIdPersona(usuariotemporal.get().getPersonaIdPersona());
                return usuario;
            }
        }
            return usuario = null;
    }


    public int validaEstado(int usuario,int estado){
        int valor = buscaEstado(estado,usuario);
        Optional<Historial>  historia = historialRepository.findById(valor);
        return estado = historia.get().getEstadoIdEstado();
    }

    public int buscaEstado(int idusuario, int estado) {
        List<Historial> historial = historialRepository.findHistorialByEstadoIdEstadoAndUsuarioIdUsuarioOrderByIdHistorial(estado, idusuario);
        int cont = 0;
        for (Historial historia : historial) {
            if (historia.getIdHistorial() > cont) {
                cont = historia.getIdHistorial();
            } else {
                cont = historia.getIdHistorial();
                return cont;
            }
        }
        return cont;
    }

}
