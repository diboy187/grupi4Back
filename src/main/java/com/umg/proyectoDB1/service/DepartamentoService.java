package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Departamento;
import com.umg.proyectoDB1.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("departamento")
@CrossOrigin
public class DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    @GetMapping(path = "/consulta")
    private List<Departamento> consulta(){
        return departamentoRepository.findAll() ;
    }


    @PostMapping(path = "/crear")
    private Departamento crea(@RequestBody Departamento departamento){
            int id = departamentoRepository.findAll().size();
            id++;
            departamento.setIdDepartamento(id);
            return  departamentoRepository.save(departamento);

    }



}
