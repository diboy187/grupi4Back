package com.umg.proyectoDB1.repository;

import com.umg.proyectoDB1.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


}
