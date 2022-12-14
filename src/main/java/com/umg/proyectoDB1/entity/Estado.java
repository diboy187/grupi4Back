package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estado")
public class Estado {
    @Id
    @Column(name = "id_estado", nullable = false)
    private Integer idEstado;

    @Column(name = "nombre_estado")
    private String nombreEstado;


    @OneToMany(mappedBy = "estadoIdEstado")
    private List<Especialista> estadoList;

    @OneToMany(mappedBy = "estadoIdEstado")
    private List<Historial> historialList;

    @OneToMany(mappedBy = "estadoIdEstado")
    private List<Reservacion> reservacionList;

    @OneToMany(mappedBy = "estadoIdEstado")
    private List<Factura> facturaList;

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public List<Especialista> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<Especialista> estadoList) {
        this.estadoList = estadoList;
    }

    public List<Historial> getHistorialList() {
        return historialList;
    }

    public void setHistorialList(List<Historial> historialList) {
        this.historialList = historialList;
    }

    public List<Reservacion> getReservacionList() {
        return reservacionList;
    }

    public void setReservacionList(List<Reservacion> reservacionList) {
        this.reservacionList = reservacionList;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }
}
