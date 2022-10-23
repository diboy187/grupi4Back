package com.umg.proyectoDB1.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "terapia_reservacion")
public class TerapiaReservacion {
    @Id
    @Column(name = "id_terapia_reservacion" )
    private Integer idTerapiaReservacion;

    @Column(name = "reservacion_id_reservacion")
    private Integer reservacionIdReservacion;


    @OneToMany(mappedBy = "terpaiaReservacionIdTerapiaReservacion")
    private List<DetalleFactura> detalleFacturaList;



    public Integer getIdTerapiaReservacion() {
        return idTerapiaReservacion;
    }

    public void setIdTerapiaReservacion(Integer idTerapiaReservacion) {
        this.idTerapiaReservacion = idTerapiaReservacion;
    }

    public Integer getReservacionIdReservacion() {
        return reservacionIdReservacion;
    }

    public void setReservacionIdReservacion(Integer reservacionIdReservacion) {
        this.reservacionIdReservacion = reservacionIdReservacion;
    }

    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }
}
