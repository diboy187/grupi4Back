package com.umg.proyectoDB1.service;
import com.umg.proyectoDB1.entity.Login;
import com.umg.proyectoDB1.entity.Usuario;
import com.umg.proyectoDB1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@RestController
@RequestMapping("/login")
@CrossOrigin

public class LoginService {

    @Autowired
    UsuarioRepository usuarioRepository;

    //Autentica al usuario y devuelve la información general de la persona
    @PostMapping(path = "/autenticacion")
    private Usuario loginTeacher(@RequestBody Login credentials) {


        System.out.println(MD5(credentials.getPass()));

        Usuario usuario = new Usuario();
        if(credentials.getUser().equals("1") && credentials.getPass().equals("admin")){
            usuario.setUsuario(credentials.getUser());
            usuario.setPassword(credentials.getPass());
        }
        return  usuario;
    }


    private static String MD5(String entrada){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(entrada.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
