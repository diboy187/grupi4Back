package com.umg.proyectoDB1.repository;

import com.umg.proyectoDB1.entity.Historial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistorialRepository extends JpaRepository<Historial, Integer> {

    List<Historial> findHistorialByEstadoIdEstadoAndUsuarioIdUsuarioOrderByIdHistorial(int estado, int usuarioIdusuario);
}
