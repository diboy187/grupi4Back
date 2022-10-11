package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sede")
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "id_sede", nullable = false)
    private Integer idSede;

    @Column(name = "sede")
    private String sede;

    @Column(name = "direccion_id_direccion")
    private Integer direccionIdDireccion;

    @OneToMany(mappedBy = "sedeIdSede")
    private List<Clinica> clinicaList;

    public List<Clinica> getClinicaList() {
        return clinicaList;
    }

    public void setClinicaList(List<Clinica> clinicaList) {
        this.clinicaList = clinicaList;
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public Integer getDireccionIdDireccion() {
        return direccionIdDireccion;
    }

    public void setDireccionIdDireccion(Integer direccionIdDireccion) {
        this.direccionIdDireccion = direccionIdDireccion;
    }
}
