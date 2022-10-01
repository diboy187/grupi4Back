package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idestado", nullable = false)
    private Integer idestado;

    @Column(name = "estado")
    private String estado;

    public Estado(){}
    public Estado(Integer idestado, String estado) {
        this.idestado = idestado;
        this.estado = estado;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
