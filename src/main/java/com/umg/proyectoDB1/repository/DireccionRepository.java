package com.umg.proyectoDB1.repository;

import com.umg.proyectoDB1.entity.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DireccionRepository extends JpaRepository<Direccion, Integer> {
    List<Direccion> findByMunicipioIdMunicipio(int municipioIdMunicipio);
}
