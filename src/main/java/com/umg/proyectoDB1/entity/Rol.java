package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idrol", nullable = false)
    private Integer idrol;

    @Column(name = "nombreRol")
    private String nombreRol;

    public Rol(){}
    public Rol(Integer idrol, String nombreRol) {
        this.idrol = idrol;
        this.nombreRol = nombreRol;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
