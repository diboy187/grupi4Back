package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idespecialidad", nullable = false)
    private Integer idespecialidad;

    @Column(name = "especialidad")
    private String especialidad;

    public Especialidad(){}
    public Especialidad(Integer idespecialidad, String especialidad) {
        this.idespecialidad = idespecialidad;
        this.especialidad = especialidad;
    }

    public Integer getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(Integer idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
