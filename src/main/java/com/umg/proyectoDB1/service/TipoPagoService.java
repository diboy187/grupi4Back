package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.TipoPago;
import com.umg.proyectoDB1.repository.TipoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("TipoPago")
@CrossOrigin
public class TipoPagoService {

    @Autowired
    TipoPagoRepository tipoPagoRepository;

    @GetMapping(path = "/consulta")
    private List<TipoPago> find(){ return tipoPagoRepository.findAll();}
}
