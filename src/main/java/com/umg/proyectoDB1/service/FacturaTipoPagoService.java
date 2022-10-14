package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.FacturaTipoPago;
import com.umg.proyectoDB1.repository.FacturaTipoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("facturaTipoPago")
@CrossOrigin
public class FacturaTipoPagoService {

    @Autowired
    FacturaTipoPagoRepository facturaTipoPagoRepository;

    @GetMapping(path = "/consulta")
    private List<FacturaTipoPago> consulta(){return facturaTipoPagoRepository.findAll();}
}
