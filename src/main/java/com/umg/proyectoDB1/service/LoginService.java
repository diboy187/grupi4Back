package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Usuario;
import com.umg.proyectoDB1.repository.EstadoRepository;
import com.umg.proyectoDB1.repository.HistorialRepository;
import com.umg.proyectoDB1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


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
    private ResponseEntity<List<Usuario>> login(@RequestBody Usuario usuario){

        int longitud = usuarioRepository.findByUsuarioAndPassword(usuario.getUsuario(),usuario.getPassword()).size();
         if( usuario.getUsuario() == null || usuario.getPassword() == null || usuario.getUsuario().isEmpty() || usuario.getPassword().isEmpty() ) {
            return  ResponseEntity.badRequest().build();
        }else if(usuario.getUsuario().equals("admin") && usuario.getPassword().equals("21232f297a57a5a743894a0e4a801fc3")){
            return ResponseEntity.ok().build();
        }else if (longitud>0){
            return  ResponseEntity.ok(usuarioRepository.findByUsuarioAndPassword(usuario.getUsuario(),usuario.getPassword()));
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }


    private void ValidaEstado(){

    }

}
