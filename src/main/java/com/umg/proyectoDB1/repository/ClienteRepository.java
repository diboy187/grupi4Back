package com.umg.proyectoDB1.repository;

import com.umg.proyectoDB1.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
}
