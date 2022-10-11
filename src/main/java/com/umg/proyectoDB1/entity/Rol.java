package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "id_rol", nullable = false)
    private Integer idRol;

    @Column(name = "nombre_rol")
    private String nombreRol;

    @OneToMany(mappedBy = "rolIdRol")
    private List<Historial> historialList;

    public List<Historial> getHistorialList() {
        return historialList;
    }

    public void setHistorialList(List<Historial> historialList) {
        this.historialList = historialList;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
