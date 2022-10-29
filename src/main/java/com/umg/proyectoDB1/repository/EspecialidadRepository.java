package com.umg.proyectoDB1.repository;

import com.umg.proyectoDB1.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {
    Optional<Especialidad> findByEspecialidad(String especialidad);
}
