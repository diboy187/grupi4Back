package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Estado;
import com.umg.proyectoDB1.entity.TipoIdentidad;
import com.umg.proyectoDB1.entity.TipoPago;
import com.umg.proyectoDB1.repository.TipoIdentidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("tipoIdentidad")
@CrossOrigin
public class TipoIdentidadService {

    @Autowired
    TipoIdentidadRepository tipoIdentidadRepository;

    @GetMapping(path = "/consulta")
    private List<TipoIdentidad> consulta(){
        return tipoIdentidadRepository.findAll();
    }

    @PostMapping(path = "/crea")
    private TipoIdentidad crea(@RequestBody TipoIdentidad tipoIdentidad){
        int id = tipoIdentidadRepository.findAll().size();
        id++;
        tipoIdentidad.setIdTipoIdentidad(id);
        return tipoIdentidadRepository.save(tipoIdentidad);
    }


    @PostMapping(path = "/actualiza")
    private TipoIdentidad actualiza(@RequestBody TipoIdentidad tipoIdentidad){
        return tipoIdentidadRepository.save(tipoIdentidad);
    }

}
