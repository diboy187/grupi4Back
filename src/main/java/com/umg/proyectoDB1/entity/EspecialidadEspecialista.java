package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "especialidad_especialista")
public class EspecialidadEspecialista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "id_especialidad_especialista", nullable = false)
    private Integer idespecialidadEspecialista;

    @Column(name = "especialida_id_especialidad")
    private Integer especialidadIdEspecialidad;

    @Column(name = "especialista_id_especialista")
    private Integer especialistaIdEspecialista;

    public Integer getIdespecialidadEspecialista() {
        return idespecialidadEspecialista;
    }

    public void setIdespecialidadEspecialista(Integer idespecialidadEspecialista) {
        this.idespecialidadEspecialista = idespecialidadEspecialista;
    }

    public Integer getEspecialidadIdEspecialidad() {
        return especialidadIdEspecialidad;
    }

    public void setEspecialidadIdEspecialidad(Integer especialidadIdEspecialidad) {
        this.especialidadIdEspecialidad = especialidadIdEspecialidad;
    }

    public Integer getEspecialistaIdEspecialista() {
        return especialistaIdEspecialista;
    }

    public void setEspecialistaIdEspecialista(Integer especialistaIdEspecialista) {
        this.especialistaIdEspecialista = especialistaIdEspecialista;
    }
}
