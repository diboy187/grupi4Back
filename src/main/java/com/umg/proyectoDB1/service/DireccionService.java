package com.umg.proyectoDB1.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.umg.proyectoDB1.entity.Departamento;
import com.umg.proyectoDB1.entity.Direccion;
import com.umg.proyectoDB1.entity.Municipio;
import com.umg.proyectoDB1.repository.DepartamentoRepository;
import com.umg.proyectoDB1.repository.DireccionRepository;
import com.umg.proyectoDB1.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("direccion")
@CrossOrigin
public class DireccionService {

    @Autowired
    DireccionRepository direccionRepository;

    @Autowired
    MunicipioRepository municipioRepository;

    @Autowired
    DepartamentoRepository departamentoRepository;

    @GetMapping(path = "/consulta")
    private List<Direccion> consulta(){
        return direccionRepository.findAll() ;
    }

    @GetMapping(path = "/consulta/{id}")
    private ArrayList consultaCliente(@PathVariable ("id") Integer id){
        ArrayList direccionCliente = new ArrayList<>();

        Optional<Direccion> direccion = direccionRepository.findById(id);
        Optional<Municipio> municipio = municipioRepository.findById(direccion.get().getMunicipioIdMunicipio());
        Optional<Departamento> departamento = departamentoRepository.findById(municipio.get().getDepartamentoIdDepartamento());
        direccionCliente.add(direccion);
        direccionCliente.add(municipio);
        direccionCliente.add(departamento);

        return direccionCliente;
    }

    @PostMapping(path = "/crea")
    private Direccion crea(@RequestBody Direccion direccion){
        if (direccion != null){
            List<Direccion> direccionList = direccionRepository.findAll();
            int contador = direccionList.size();
            contador++;
            direccion.setIdDireccion(contador);
            direccionRepository.save(direccion);
            return direccion;
        }else {
            return direccion = null;
        }
    }


}
