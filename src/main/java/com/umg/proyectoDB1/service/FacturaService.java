package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Factura;
import com.umg.proyectoDB1.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Factura")
@CrossOrigin
public class FacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    @GetMapping(path = "/consulta")
    private List<Factura> consulta(){
        return facturaRepository.findAll();
    }

}
