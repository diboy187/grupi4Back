package com.umg.proyectoDB1.repository;

import com.umg.proyectoDB1.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    public Optional<Persona> findByIdPersona(int idPersona);
}
