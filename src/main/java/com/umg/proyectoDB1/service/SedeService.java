package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Direccion;
import com.umg.proyectoDB1.entity.Sede;
import com.umg.proyectoDB1.repository.DireccionRepository;
import com.umg.proyectoDB1.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("sede")
@CrossOrigin
public class SedeService {

    @Autowired
    SedeRepository sedeRepository;

    @Autowired
    DireccionRepository direccionRepository;

    @GetMapping(path = "/consulta")
    private List<Sede> consulta(){return sedeRepository.findAll();}

    @GetMapping(path = "/consulta/{id}")
    private List<Sede> consultaSede(@PathVariable ("id") Integer id){
        List<Direccion> direccionList = direccionRepository.findByMunicipioIdMunicipio(id);
        List<Sede> sedeList = sedeRepository.findAll();
        List<Sede> sedeList1 = new ArrayList<>();

        for (Direccion direccion: direccionList){
            for(Sede sede: sedeList){
                if (direccion.getIdDireccion().equals(sede.getDireccionIdDireccion())){
                    sedeList1.add(sede);
                }
            }
        }

        return sedeList1;
    }

    @PostMapping(path = "/crea")
    private Sede crea(@RequestBody Sede sede){
        int id = sedeRepository.findAll().size();
        id++;
        sede.setIdSede(id);
        return sedeRepository.save(sede);
    }


}
