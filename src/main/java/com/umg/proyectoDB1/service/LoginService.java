package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Historial;
import com.umg.proyectoDB1.entity.Rol;
import com.umg.proyectoDB1.entity.Usuario;
import com.umg.proyectoDB1.repository.EstadoRepository;
import com.umg.proyectoDB1.repository.HistorialRepository;
import com.umg.proyectoDB1.repository.RolRepository;
import com.umg.proyectoDB1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    RolRepository rolRepository;

    //login
    @PostMapping(path = "/autenticacion")
    private String login(@RequestBody Usuario usuario) {
        int longitud = usuarioRepository.findByUsuarioAndPassword(usuario.getUsuario(), usuario.getPassword()).size();
        if (usuario.getUsuario() == null || usuario.getPassword() == null || usuario.getUsuario().isEmpty() || usuario.getPassword().isEmpty()) {
            return "{\"CodError\":\"1\",\"Rol\":\"null\",Usuario\" :\"no valido\"}";
        } else if (usuario.getUsuario().equals("admin") && usuario.getPassword().equals("21232f297a57a5a743894a0e4a801fc3")) {
            return  "{\"CodError\":\"0\",\"Rol\":\"admin\",Usuario\" :\"admin\" }";
        } else if (longitud > 0) {
            Optional<Usuario> usuariotemporal = usuarioRepository.findByUsuario(usuario.getUsuario());
            int estadoUsuario = usuariotemporal.get().getIdUsuario();
            int estado = validaEstado(estadoUsuario, 1);
            if (estado == 1) {
                usuario.setIdUsuario(usuariotemporal.get().getIdUsuario());
                usuario.setPersonaIdPersona(usuariotemporal.get().getPersonaIdPersona());
                Optional<Historial> historial = historialRepository.findById(usuario.getIdUsuario());
                int idRol = historial.get().getRolIdRol();
                Optional<Rol> rol = rolRepository.findById(idRol);
                String rolValor = rol.get().getNombreRol();
                return "{\"CodError\":\"0\",\"Rol\":"+rolValor+",Usuario\":"+usuario.getUsuario()+"\"}";
            }
        }
        return "{\"CodError\":\"2\",\"Rol\":\"null\",Usuario\":\"no esta!\" }";
    }




    public int validaEstado(int usuario, int estado) {
        int valor = buscaEstado(estado, usuario);
        Optional<Historial> historia = historialRepository.findById(valor);
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
