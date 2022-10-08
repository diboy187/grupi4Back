package com.umg.proyectoDB1.service;
import com.umg.proyectoDB1.entity.Login;
import com.umg.proyectoDB1.entity.Persona;
import com.umg.proyectoDB1.entity.Usuario;
import com.umg.proyectoDB1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/login")
@CrossOrigin

public class LoginService {

    @Autowired
    UsuarioRepository usuarioRepository;

    //Autentica al usuario y devuelve la información general de la persona
    @PostMapping(path = "/autenticacion")
    private Usuario loginTeacher(@RequestBody Login credentials) {

        Usuario usuario = new Usuario();
        if(credentials.getUser().equals("admin") && credentials.getPass().equals("admin")){
            usuario.setIdusuario(credentials.getUser());
            usuario.setPassword(credentials.getPass());
        }

        return  usuario;
    }

}
