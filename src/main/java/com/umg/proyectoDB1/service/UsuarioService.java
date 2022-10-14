package com.umg.proyectoDB1.service;



import com.umg.proyectoDB1.entity.Usuario;
import com.umg.proyectoDB1.repository.PersonaRepository;
import com.umg.proyectoDB1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("usuario")
@CrossOrigin
public class UsuarioService {


    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping(path = "/consulta")
    private List<Usuario> find(){ return usuarioRepository.findAll();}





}
