package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "id_factura", nullable = false)
    private Integer idFactura;

    @Column(name = "numero_factura")
    private Integer numeroFactura;

    @Column(name = "serie_factura")
    private String serieFactura;

    @Column(name = "factura_tipo_pago_id_factura_tipo_pago")
    private Integer facturaTipoPagoIdFacturaTipoPago;

    @Column(name = "estado_id_estado")
    private Integer estadoIdEstado;

    @OneToMany(mappedBy = "facturaIdFactura")
    private List<DetalleFactura> detalleFacturaList;


    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
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

    public Integer getFacturaTipoPagoIdFacturaTipoPago() {
        return facturaTipoPagoIdFacturaTipoPago;
    }

    public void setFacturaTipoPagoIdFacturaTipoPago(Integer facturaTipoPagoIdFacturaTipoPago) {
        this.facturaTipoPagoIdFacturaTipoPago = facturaTipoPagoIdFacturaTipoPago;
    }

    public Integer getEstadoIdEstado() {
        return estadoIdEstado;
    }

    public void setEstadoIdEstado(Integer estadoIdEstado) {
        this.estadoIdEstado = estadoIdEstado;
    }
}
