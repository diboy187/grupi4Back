package com.umg.proyectoDB1.service;


import com.umg.proyectoDB1.entity.Terapia;
import com.umg.proyectoDB1.entity.TerapiaReservacion;
import com.umg.proyectoDB1.entity.TipoIdentidad;
import com.umg.proyectoDB1.repository.TerapiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("terapia")
@CrossOrigin
public class TerapiaService {

    @Autowired
    TerapiaRepository terapiaRepository;

    @GetMapping(path = "/consulta")
    private List<Terapia> consulta(){
        return terapiaRepository.findAll();
    }

    @PostMapping(path = "/crea")
    private Terapia crea(@RequestBody Terapia terapia){
        int id = terapiaRepository.findAll().size();
        id++;
        terapia.setIdTerapia(id);
        return terapiaRepository.save(terapia);
    }
}
