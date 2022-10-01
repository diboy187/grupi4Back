package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "terapia")
public class Terapia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idterapia", nullable = false)
    private Integer idterapia;

    @Column(name = "terapia")
    private String terapia;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private Double precio;

    public Terapia(){}
    public Terapia(Integer idterapia, String terapia, String descripcion, Double precio) {
        this.idterapia = idterapia;
        this.terapia = terapia;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Integer getIdterapia() {
        return idterapia;
    }

    public void setIdterapia(Integer idterapia) {
        this.idterapia = idterapia;
    }

    public String getTerapia() {
        return terapia;
    }

    public void setTerapia(String terapia) {
        this.terapia = terapia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
