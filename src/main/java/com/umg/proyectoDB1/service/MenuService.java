package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Menu;
import com.umg.proyectoDB1.entity.MenuRol;
import com.umg.proyectoDB1.repository.MenuRepository;
import com.umg.proyectoDB1.repository.MenuRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu")
@CrossOrigin
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    MenuRolRepository menuRolRepository;



    @GetMapping(path = "/consulta")
    private List<Menu> consulta(){
        return menuRepository.findAll();
    }

    @GetMapping(path ="/consultaRol" )
    private List<MenuRol> consultaRol(){
        return menuRolRepository.findAll();
    }
}
