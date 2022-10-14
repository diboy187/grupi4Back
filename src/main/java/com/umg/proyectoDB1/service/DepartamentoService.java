package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Departamento;
import com.umg.proyectoDB1.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("departamento")
@CrossOrigin
public class DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    @GetMapping(path = "/consulta")
    private List<Departamento> find(){
        return departamentoRepository.findAll() ;
    }


    @PostMapping(path = "/crear")
    private String crea(@RequestBody Departamento departamento){
        if (departamento != null){

            departamentoRepository.save(departamento);
            return "Creado exitosamente";
        }else {
            return "Error al crear el departamento";
        }


    }

    @DeleteMapping(path = "/borrado/{id}")
    private String borra(@PathVariable ("id") int id){
        if ( id > -1){
            departamentoRepository.deleteById(id);
            return  "Eliminado exitosamente" ;
        }else{
            return  "No fue posible eliminar verifique el id";
        }

    }

}
