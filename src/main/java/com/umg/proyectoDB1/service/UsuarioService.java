package com.umg.proyectoDB1.service;


import com.umg.proyectoDB1.entity.Usuario;
import com.umg.proyectoDB1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("usuario")
@CrossOrigin
public class UsuarioService {


    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping(path = "/consulta")
    private List<Usuario> find(){ return usuarioRepository.findAll();}

    @PostMapping(path = "/crea")
    private Usuario crea(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @GetMapping(path = "/c")
    private void test(HttpServletResponse response)throws IOException {

        response.setStatus(200);
        response.getWriter().println("Hello World!"  );
    }


}
