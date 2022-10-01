package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "clinicaEspecialidad")
public class ClinicaEspecialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idclinica_especialidad", nullable = false)
    private Integer idclinicaEspecialidad;

    public Integer getIdclinicaEspecialidad() {
        return idclinicaEspecialidad;
    }

    public void setIdclinicaEspecialidad(Integer idclinicaEspecialidad) {
        this.idclinicaEspecialidad = idclinicaEspecialidad;
    }
}
