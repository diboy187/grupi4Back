package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @Column(name = "id_especialidad", nullable = false)
    private Integer idEspecialidad;

    @Column(name = "especialidad")
    private String especialidad;



    @OneToMany(mappedBy = "especialidadIdEspecialidad")
    private List<ClinicaEspecialidad> especialidadList;

    @OneToMany(mappedBy = "especialidadIdEspecialidad")
    private List<EspecialidadEspecialista> especialidadEspecialistaList;

    @OneToMany(mappedBy = "especialidadIdEspecialidad")
    private List<Terapia> terapiaList;



    public List<Terapia> getTerapiaList() {
        return terapiaList;
    }

    public void setTerapiaList(List<Terapia> terapiaList) {
        this.terapiaList = terapiaList;
    }

    public List<EspecialidadEspecialista> getEspecialidadEspecialistaList() {
        return especialidadEspecialistaList;
    }

    public void setEspecialidadEspecialistaList(List<EspecialidadEspecialista> especialidadEspecialistaList) {
        this.especialidadEspecialistaList = especialidadEspecialistaList;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<ClinicaEspecialidad> getEspecialidadList() {
        return especialidadList;
    }

    public void setEspecialidadList(List<ClinicaEspecialidad> especialidadList) {
        this.especialidadList = especialidadList;
    }
}
