package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historial")
public class Historial {
    @Id
    @Column(name = "id_historial", nullable = false)
    private Integer idHistorial;

    @Column(name = "fecha_cambio")
    private LocalDateTime fechaCambio;

    @Column(name = "usuario_id_usuario")
    private Integer usuarioIdUsuario;

    @Column(name = "estado_id_estado")
    private Integer estadoIdEstado;

    @Column(name = "rol_id_rol")
    private Integer rolIdRol;



    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public LocalDateTime getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(LocalDateTime fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public Integer getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Integer usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public Integer getEstadoIdEstado() {
        return estadoIdEstado;
    }

    public void setEstadoIdEstado(Integer estadoIdEstado) {
        this.estadoIdEstado = estadoIdEstado;
    }

    public Integer getRolIdRol() {
        return rolIdRol;
    }

    public void setRolIdRol(Integer rolIdRol) {
        this.rolIdRol = rolIdRol;
    }
}
