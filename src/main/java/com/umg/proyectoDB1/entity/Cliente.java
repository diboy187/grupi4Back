package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idcliente", nullable = false)
    private Integer idcliente;

    @Column(name = "antiguedad")
    private String antiguedad;

    public Cliente(){}
    public Cliente(Integer idcliente, String antiguedad) {
        this.idcliente = idcliente;
        this.antiguedad = antiguedad;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }
}
