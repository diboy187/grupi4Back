package com.umg.proyectoDB1.repository;

import com.umg.proyectoDB1.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoEntity extends JpaRepository<Departamento, Integer> {
}
