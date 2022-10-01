package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "municipio")
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idmunicipio", nullable = false)
    private Integer idmunicipio;

    @Column(name = "municipio")
    private String municipio;

    public Municipio(){}
    public Municipio(Integer idmunicipio, String municipio) {
        this.idmunicipio = idmunicipio;
        this.municipio = municipio;
    }

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
}
