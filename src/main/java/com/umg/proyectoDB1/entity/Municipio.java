package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "municipio")
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "id_municipio", nullable = false)
    private Integer idmunicipio;

    @Column(name = "municipio")
    private String municipio;


    @Column(name = "departamento_id_departamento")
    private Integer departamentoIdDepartamento;

    @OneToMany(mappedBy = "municipioIdMunicipio")
    private List<Direccion> direccionList;





    public Integer getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Integer getDepartamentoIdDepartamento() {
        return departamentoIdDepartamento;
    }

    public void setDepartamentoIdDepartamento(Integer departamentoIdDepartamento) {
        this.departamentoIdDepartamento = departamentoIdDepartamento;
    }

    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }
}
