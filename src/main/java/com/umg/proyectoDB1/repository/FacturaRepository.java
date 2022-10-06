package com.umg.proyectoDB1.repository;

import com.umg.proyectoDB1.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}
