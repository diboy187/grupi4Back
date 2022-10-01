package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "tipoIdentidad")
public class TipoIdentidad {

    private static final long serialVersionUID = 3760988163877761705L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idtipoIdentidad")
    private Integer idTipoIdentidad;

    @Column(name = "tipoIdentidad")
    String tipoIdentidad;

    public TipoIdentidad(){}

    public TipoIdentidad(Integer idTipoIdentidad, String tipoIdentidad, Integer tipoIdentidadList) {
        this.idTipoIdentidad = idTipoIdentidad;
        this.tipoIdentidad = tipoIdentidad;
    }

    public Integer getIdTipoIdentidad() {
        return idTipoIdentidad;
    }

    public void setIdTipoIdentidad(Integer idTipoIdentidad) {
        this.idTipoIdentidad = idTipoIdentidad;
    }

    public String getTipoIdentidad() {
        return tipoIdentidad;
    }

    public void setTipoIdentidad(String tipoIdentidad) {
        this.tipoIdentidad = tipoIdentidad;
    }
}
