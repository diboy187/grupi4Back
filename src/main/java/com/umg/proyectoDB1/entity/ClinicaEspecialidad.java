package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "clinica_especialidad")
public class ClinicaEspecialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "id_clinica_especialidad", nullable = false)
    private Integer idClinicaEspecialidad;

    @Column(name = "clinica_id_clinica")
    private Integer clinicaIdClinica;

    @Column(name = "especialidad_id_especialidad")
    private Integer especialidadIdEspecialidad;

    public Integer getIdClinicaEspecialidad() {
        return idClinicaEspecialidad;
    }

    public void setIdClinicaEspecialidad(Integer idClinicaEspecialidad) {
        this.idClinicaEspecialidad = idClinicaEspecialidad;
    }

    public Integer getClinicaIdClinica() {
        return clinicaIdClinica;
    }

    public void setClinicaIdClinica(Integer clinicaIdClinica) {
        this.clinicaIdClinica = clinicaIdClinica;
    }

    public Integer getEspecialidadIdEspecialidad() {
        return especialidadIdEspecialidad;
    }

    public void setEspecialidadIdEspecialidad(Integer especialidadIdEspecialidad) {
        this.especialidadIdEspecialidad = especialidadIdEspecialidad;
    }
}
