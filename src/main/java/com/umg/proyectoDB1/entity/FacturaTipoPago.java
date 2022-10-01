package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "facturaTipoPago")
public class FacturaTipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idfactura_tipo_pago", nullable = false)
    private Integer idfacturaTipoPago;

    @Column(name = "cantidad")
    private Double cantidad;

    public FacturaTipoPago(){}
    public FacturaTipoPago(Integer idfacturaTipoPago, Double cantidad) {
        this.idfacturaTipoPago = idfacturaTipoPago;
        this.cantidad = cantidad;
    }

    public Integer getIdfacturaTipoPago() {
        return idfacturaTipoPago;
    }

    public void setIdfacturaTipoPago(Integer idfacturaTipoPago) {
        this.idfacturaTipoPago = idfacturaTipoPago;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
