package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idfactura", nullable = false)
    private Integer idfactura;

    @Column(name = "nit")
    private String nit;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "numeroFactura")
    private Integer numeroFactura;

    @Column(name = "serieFactura")
    private String serieFactura;

    public Factura(){}
    public Factura(Integer idfactura, String nit, String direccion, String nombre, Integer numeroFactura, String serieFactura) {
        this.idfactura = idfactura;
        this.nit = nit;
        this.direccion = direccion;
        this.nombre = nombre;
        this.numeroFactura = numeroFactura;
        this.serieFactura = serieFactura;
    }

    public Integer getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getSerieFactura() {
        return serieFactura;
    }

    public void setSerieFactura(String serieFactura) {
        this.serieFactura = serieFactura;
    }
}
