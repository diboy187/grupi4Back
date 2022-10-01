package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historial")
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idhistorial", nullable = false)
    private Integer idhistorial;

    @Column(name = "fechaCambio")
    private Date fechaCambio;

    public Historial(){}
    public Historial(Integer idhistorial, Date fechaCambio) {
        this.idhistorial = idhistorial;
        this.fechaCambio = fechaCambio;
    }

    public Integer getIdhistorial() {
        return idhistorial;
    }

    public void setIdhistorial(Integer idhistorial) {
        this.idhistorial = idhistorial;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }
}
