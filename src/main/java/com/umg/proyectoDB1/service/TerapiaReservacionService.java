package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Terapia;
import com.umg.proyectoDB1.entity.TerapiaReservacion;
import com.umg.proyectoDB1.repository.TerapiaReservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("terapiaReservacion")
@CrossOrigin
public class TerapiaReservacionService {

    @Autowired
    TerapiaReservacionRepository terapiaReservacionRepository;

    @PostMapping(path = "/crea/{id}")
    private List<TerapiaReservacion> crea(@PathVariable ("id") Integer idReservacion,@RequestBody List<Terapia> terapiaList){

        int cont = terapiaReservacionRepository.findAll().size();
        List<TerapiaReservacion> terapiaReservacionListReturn = new ArrayList<>();
        for(Terapia terapia: terapiaList){
            cont++;
            System.out.println(terapia);
            TerapiaReservacion terapiaReservacion = new TerapiaReservacion();
            terapiaReservacion.setIdTerapiaReservacion(cont);
            terapiaReservacion.setReservacionIdReservacion(idReservacion);
            terapiaReservacion.setTerapiaIdTerapia(terapia.getIdTerapia());
            terapiaReservacionListReturn.add(terapiaReservacion);
            terapiaReservacionRepository.save(terapiaReservacion);
        }

        return terapiaReservacionListReturn;
    }
}
