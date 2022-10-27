package com.umg.proyectoDB1.repository;

import com.umg.proyectoDB1.entity.ClinicaEspecialidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicaEspecialidadRepository extends JpaRepository<ClinicaEspecialidad, Integer> {
    public List<ClinicaEspecialidad> findByClinicaIdClinica(int id);
}
