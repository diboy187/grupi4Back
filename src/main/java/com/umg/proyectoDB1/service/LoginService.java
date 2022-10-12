package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Usuario;
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


   /* @PostMapping(path = "/autenticacion")
    private Usuario loginTeacher(@RequestBody Login credentials) {
        MD5 md5 = new MD5();
        System.out.println(md5.convierte(credentials.getPass()));
        Usuario usuario = new Usuario();
        if(credentials.getUser().equals("1") && credentials.getPass().equals("admin")){
            usuario.setUsuario(credentials.getUser());
            usuario.setPassword(credentials.getPass());
        }
        return  usuario;
    }*/




//login
    @PostMapping(path = "/autenticacion")
    private ResponseEntity<List<Usuario>> login(@RequestBody Usuario usuario){

        int longitud = usuarioRepository.findByUsuarioAndPassword(usuario.getUsuario(),usuario.getPassword()).size();
        List<Usuario> findUser =  usuarioRepository.findByUsuarioAndPassword(usuario.getUsuario(),usuario.getPassword());
        if(usuario.getUsuario().isEmpty() || usuario.getPassword().isEmpty()) {
            return  ResponseEntity.badRequest().build();
        }else if(usuario.getUsuario().equals("admin") && usuario.getPassword().equals("admin")){
            return ResponseEntity.ok().build();
        }else if (longitud>0){
            return  ResponseEntity.ok(usuarioRepository.findByUsuarioAndPassword(usuario.getUsuario(),usuario.getPassword()));
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }


}
