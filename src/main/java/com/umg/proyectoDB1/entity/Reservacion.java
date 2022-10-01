package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservacion")
public class Reservacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idreservacion", nullable = false)
    private Integer idreservacion;

    @Column(name = "datosCita")
    private String datosCita;

    @Column(name = "fechaCita")
    private Date fechaCita;

    public Reservacion(){}
    public Reservacion(Integer idreservacion, String datosCita, Date fechaCita) {
        this.idreservacion = idreservacion;
        this.datosCita = datosCita;
        this.fechaCita = fechaCita;
    }

    public Integer getIdreservacion() {
        return idreservacion;
    }

    public void setIdreservacion(Integer idreservacion) {
        this.idreservacion = idreservacion;
    }

    public String getDatosCita() {
        return datosCita;
    }

    public void setDatosCita(String datosCita) {
        this.datosCita = datosCita;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }
}
