package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura_tipo_pago")
public class FacturaTipoPago {
    @Id
    @Column(name = "id_factura_tipo_pago", nullable = false)
    private Integer idFacturaTipoPago;

    @Column(name = "cantidad")
    private Double cantidad;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "tipo_pago_id_tipo_pago")
    private Integer tipoPagoIdtipoPago;


    @OneToMany(mappedBy = "facturaTipoPagoIdFacturaTipoPago")
    private List<Factura> facturaList;

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public Integer getIdFacturaTipoPago() {
        return idFacturaTipoPago;
    }

    public void setIdFacturaTipoPago(Integer idFacturaTipoPago) {
        this.idFacturaTipoPago = idFacturaTipoPago;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getTipoPagoIdtipoPago() {
        return tipoPagoIdtipoPago;
    }

    public void setTipoPagoIdtipoPago(Integer tipoPagoIdtipoPago) {
        this.tipoPagoIdtipoPago = tipoPagoIdtipoPago;
    }
}
