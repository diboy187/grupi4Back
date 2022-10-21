package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Cliente;
import com.umg.proyectoDB1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
@CrossOrigin
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping(path = "/consulta")
    private List<Cliente> consulta(){ return clienteRepository.findAll();}




}
