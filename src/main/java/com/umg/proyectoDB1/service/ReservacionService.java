package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Reservacion;
import com.umg.proyectoDB1.repository.ReservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Reservacion")
@CrossOrigin
public class ReservacionService {

    @Autowired
    ReservacionRepository reservacionRepository;

    @GetMapping(path = "/consulta")
    private List<Reservacion> consulta(){
        return reservacionRepository.findAll();
    }
}
