package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clinica_especialidad")
public class ClinicaEspecialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "id_clinica_especialidad", nullable = false)
    private Integer idClinicaEspecialidad;

    //fk de Clinica
    @Column(name = "clinica_id_clinica")
    private Integer clinicaIdClinica;

    //fk de especialidad
    @Column(name = "especialidad_id_especialidad")
    private Integer especialidadIdEspecialidad;

    //fk hacia reservacion
    @OneToMany(mappedBy = "clinicaEspecialidadIdClinicaEspecialidad")
    private List<Reservacion> reservacionList;

    public List<Reservacion> getReservacionList() {
        return reservacionList;
    }

    public void setReservacionList(List<Reservacion> reservacionList) {
        this.reservacionList = reservacionList;
    }

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
