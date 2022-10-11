package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "terapia")
public class Terapia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "id_terapia", nullable = false)
    private Integer idTerapia;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "terapia")
    private String terapia;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "especialidad_id_especialidad")
    private Integer especialidadIdEspecialidad;

    @OneToMany(mappedBy = "reservacionIdReservacion")
    private List<TerapiaReservacion> terapiaReservacionList;




    public Integer getIdTerapia() {
        return idTerapia;
    }

    public void setIdTerapia(Integer idTerapia) {
        this.idTerapia = idTerapia;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTerapia() {
        return terapia;
    }

    public void setTerapia(String terapia) {
        this.terapia = terapia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEspecialidadIdEspecialidad() {
        return especialidadIdEspecialidad;
    }

    public void setEspecialidadIdEspecialidad(Integer especialidadIdEspecialidad) {
        this.especialidadIdEspecialidad = especialidadIdEspecialidad;
    }

    public List<TerapiaReservacion> getTerapiaReservacionList() {
        return terapiaReservacionList;
    }

    public void setTerapiaReservacionList(List<TerapiaReservacion> terapiaReservacionList) {
        this.terapiaReservacionList = terapiaReservacionList;
    }
}
