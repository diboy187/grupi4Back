package com.umg.proyectoDB1.repository;

import com.umg.proyectoDB1.entity.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicaRepository extends JpaRepository<Clinica, Integer> {
    public List<Clinica> findBySedeIdSede(int sedeIdSede);
}
