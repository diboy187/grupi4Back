package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "id_detalle_factura", nullable = false)
    private Integer idDetalleFactura;


    //fk de factura_id_factura
    @Column(name = "factura_id_factura")
    private Integer facturaIdFactura;
    //fk de terapia_reservacion_id_terapia_reservacion
    @Column(name = "terapia_reservacion_id_terapia_reservacion")
    private Integer terpaiaReservacionIdTerapiaReservacion;


    public Integer getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(Integer idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public Integer getFacturaIdFactura() {
        return facturaIdFactura;
    }

    public void setFacturaIdFactura(Integer facturaIdFactura) {
        this.facturaIdFactura = facturaIdFactura;
    }

    public Integer getTerpaiaReservacionIdTerapiaReservacion() {
        return terpaiaReservacionIdTerapiaReservacion;
    }

    public void setTerpaiaReservacionIdTerapiaReservacion(Integer terpaiaReservacionIdTerapiaReservacion) {
        this.terpaiaReservacionIdTerapiaReservacion = terpaiaReservacionIdTerapiaReservacion;
    }
}
