package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "detalleFactura")
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "iddetalle_factura", nullable = false)
    private Long iddetalleFactura;

    public DetalleFactura(){}
    public DetalleFactura(Long iddetalleFactura) {
        this.iddetalleFactura = iddetalleFactura;
    }

    public Long getIddetalleFactura() {
        return iddetalleFactura;
    }

    public void setIddetalleFactura(Long iddetalleFactura) {
        this.iddetalleFactura = iddetalleFactura;
    }
}
