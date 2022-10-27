package com.umg.proyectoDB1.repository;

import com.umg.proyectoDB1.entity.EspecialidadEspecialista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EspecialidadEspecialistaRepository extends JpaRepository<EspecialidadEspecialista, Integer> {
    public List<EspecialidadEspecialista> findByEspecialidadIdEspecialidad(int especialidadIdEspecialida);
}
