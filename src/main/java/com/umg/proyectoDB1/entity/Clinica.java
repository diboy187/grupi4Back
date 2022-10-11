package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clinica")
public class Clinica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "id_clinica", nullable = false)
    private Integer idclinica;

    @Column(name = "clinica")
    private String clinica;


    //fk para sede
    @Column(name = "sede_id_sede")
    private Integer sedeIdSede;

    //fk hacia clinica_especialidad
    @OneToMany(mappedBy = "clinicaIdClinica")
    private List<ClinicaEspecialidad> clinicaEspecialidadList;



    public Integer getIdclinica() {
        return idclinica;
    }

    public void setIdclinica(Integer idclinica) {
        this.idclinica = idclinica;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public Integer getSedeIdSede() {
        return sedeIdSede;
    }

    public void setSedeIdSede(Integer sedeIdSede) {
        this.sedeIdSede = sedeIdSede;
    }

    public List<ClinicaEspecialidad> getClinicaEspecialidadList() {
        return clinicaEspecialidadList;
    }

    public void setClinicaEspecialidadList(List<ClinicaEspecialidad> clinicaEspecialidadList) {
        this.clinicaEspecialidadList = clinicaEspecialidadList;
    }
}
