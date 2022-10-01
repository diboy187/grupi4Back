package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "tipoPago")
public class TipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idtipo_pago", nullable = false)
    private Integer idtipoPago;

    @Column(name = "tipoPago")
    private String tipoPago;

    public TipoPago(){}
    public TipoPago(Integer idtipoPago, String tipoPago) {
        this.idtipoPago = idtipoPago;
        this.tipoPago = tipoPago;
    }

    public Integer getIdtipoPago() {
        return idtipoPago;
    }

    public void setIdtipoPago(Integer idtipoPago) {
        this.idtipoPago = idtipoPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
}
