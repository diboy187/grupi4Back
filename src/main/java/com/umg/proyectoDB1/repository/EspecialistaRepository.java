package com.umg.proyectoDB1.repository;

import com.umg.proyectoDB1.entity.Especialista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EspecialistaRepository extends JpaRepository<Especialista, Integer> {
    Optional<Especialista> findByPersonaIdPersona(int personaIdPersona);
}
