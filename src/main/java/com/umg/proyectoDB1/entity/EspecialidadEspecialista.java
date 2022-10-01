package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "especialidadEspecialista")
public class EspecialidadEspecialista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idespecialidad_especialista", nullable = false)
    private Integer idespecialidadEspecialista;

    public EspecialidadEspecialista(){}
    public EspecialidadEspecialista(Integer idespecialidadEspecialista) {
        this.idespecialidadEspecialista = idespecialidadEspecialista;
    }

    public Integer getIdespecialidadEspecialista() {
        return idespecialidadEspecialista;
    }

    public void setIdespecialidadEspecialista(Integer idespecialidadEspecialista) {
        this.idespecialidadEspecialista = idespecialidadEspecialista;
    }
}
