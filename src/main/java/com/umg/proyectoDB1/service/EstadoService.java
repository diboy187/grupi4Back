package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Estado;
import com.umg.proyectoDB1.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("estado")
@CrossOrigin
public class EstadoService {

    @Autowired
    EstadoRepository estadoRepository;

    @GetMapping(path = "/consulta")
    private List<Estado> consulta(){
        return estadoRepository.findAll();
    }

    @PostMapping(path = "/crea")
    private Estado crea(@RequestBody Estado estado){
        int cont = estadoRepository.findAll().size();
        cont++;
        estado.setIdEstado(cont);
        return estadoRepository.save(estado);
    }
}
