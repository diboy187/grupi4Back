package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Clinica;
import com.umg.proyectoDB1.entity.Terapia;
import com.umg.proyectoDB1.repository.ClinicaEspecialidadRepository;
import com.umg.proyectoDB1.repository.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clinica")
@CrossOrigin
public class ClinicaService {

    @Autowired
    ClinicaRepository clinicaRepository;

    @Autowired
    ClinicaEspecialidadRepository clinicaEspecialidadRepository;

    @GetMapping(path = "/consulta")
    private List<Clinica> consulta(){return clinicaRepository.findAll();}

    @PostMapping(path = "/consulta/{id}")
    private List<Clinica> consultaClinica(@PathVariable("id") Integer id, @RequestBody List<Terapia> terapiaList){
        List<Clinica> clinicaList = clinicaRepository.findAll();
        List<Clinica> clinicaList1 = new ArrayList<>();
        for(Terapia terapia: terapiaList){
            for (Clinica clinica: clinicaList){
                if(clinica.getSedeIdSede() == id && clinica.getClinicaEspecialidadList().get(0).getEspecialidadIdEspecialidad() == terapia.getEspecialidadIdEspecialidad()){
                    clinicaList1.add(clinica);
                }
            }
        }

        return clinicaList1;
    }

    @PostMapping(path = "/crea")
    private Clinica crea(@RequestBody Clinica clinica){
        int cont = clinicaRepository.findAll().size();
        cont++;
        clinica.setIdclinica(cont);
        return clinicaRepository.save(clinica);
    }
}
