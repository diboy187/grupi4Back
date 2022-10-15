package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Historial;
import com.umg.proyectoDB1.entity.Usuario;
import com.umg.proyectoDB1.repository.HistorialRepository;
import com.umg.proyectoDB1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("usuario")
@CrossOrigin
public class UsuarioService {


    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    HistorialRepository historialRepository;

    @GetMapping(path = "/consulta")
    private List<Usuario> consulta(){ return usuarioRepository.findAll();}


    @PostMapping(path = "/actualiza")
    private Usuario actualiza(@RequestBody Usuario usuario){
        Optional<Usuario> usuarioRecuperado = usuarioRepository.findByUsuario(usuario.getUsuario());
        usuario.setIdUsuario(usuarioRecuperado.get().getIdUsuario());
        usuario.setPersonaIdPersona(usuarioRecuperado.get().getPersonaIdPersona());
        return usuarioRepository.save(usuario);
    }







}
