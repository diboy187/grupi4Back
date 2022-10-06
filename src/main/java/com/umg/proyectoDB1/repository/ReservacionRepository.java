package com.umg.proyectoDB1.repository;

import com.umg.proyectoDB1.entity.Reservacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservacionRepository extends JpaRepository<Reservacion, Integer> {
}
