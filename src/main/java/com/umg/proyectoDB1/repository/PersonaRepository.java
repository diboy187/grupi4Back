package com.umg.proyectoDB1.repository;

import com.umg.proyectoDB1.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
