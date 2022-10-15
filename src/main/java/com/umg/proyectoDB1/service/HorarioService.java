package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Horario;
import com.umg.proyectoDB1.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("horario")
@CrossOrigin
public class HorarioService {

    @Autowired
    HorarioRepository horarioRepository;

    @GetMapping(path = "/consulta")
    private List<Horario> consulta(){
        return horarioRepository.findAll();
    }

    @GetMapping(path = "/consulta/{id}")
    private Optional<Horario> consulta(@PathVariable ("id") int id){
        return horarioRepository.findById(id);
    }

    @PostMapping(path = "/crea")
    private Horario crea(@RequestBody Horario horario){
        return horarioRepository.save(horario);
    }


}
