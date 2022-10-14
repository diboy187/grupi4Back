package com.umg.proyectoDB1.service;


import com.umg.proyectoDB1.entity.Cliente;
import com.umg.proyectoDB1.entity.Persona;
import com.umg.proyectoDB1.repository.ClienteRepository;
import com.umg.proyectoDB1.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("cliente")
@CrossOrigin
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;



    @GetMapping(path = "/consulta")
    private List<Cliente> find(){ return clienteRepository.findAll();}




}
