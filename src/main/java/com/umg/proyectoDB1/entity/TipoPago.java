package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipo_pago")
public class TipoPago {
    @Id
    @Column(name = "id_tipo_pago", nullable = false)
    private Integer idTipoPago;

    @Column(name = "tipo_pago")
    private String tipoPago;


    @OneToMany(mappedBy = "tipoPagoIdtipoPago")
    private List<FacturaTipoPago> facturaTipoPagoList;

    public List<FacturaTipoPago> getFacturaTipoPagoList() {
        return facturaTipoPagoList;
    }

    public void setFacturaTipoPagoList(List<FacturaTipoPago> facturaTipoPagoList) {
        this.facturaTipoPagoList = facturaTipoPagoList;
    }

    public Integer getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
}
