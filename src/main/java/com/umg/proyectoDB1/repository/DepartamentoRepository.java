package com.umg.proyectoDB1.repository;

import com.umg.proyectoDB1.entity.Departamento;
import com.umg.proyectoDB1.entity.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {


}
