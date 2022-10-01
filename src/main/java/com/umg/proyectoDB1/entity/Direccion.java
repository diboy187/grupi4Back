package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "iddireccion", nullable = false)
    private Integer iddireccion;

    @Column(name = "calle")
    private String calle;

    @Column(name = "avenida")
    private String avenida;

    @Column(name = "otros")
    private String otros;

    public Direccion(){}
    public Direccion(Integer iddireccion, String calle, String avenida, String otros) {
        this.iddireccion = iddireccion;
        this.calle = calle;
        this.avenida = avenida;
        this.otros = otros;
    }

    public Integer getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(Integer iddireccion) {
        this.iddireccion = iddireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getAvenida() {
        return avenida;
    }

    public void setAvenida(String avenida) {
        this.avenida = avenida;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }
}
