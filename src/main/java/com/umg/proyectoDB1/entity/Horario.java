package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "horario")
public class Horario {
    @Id
    @Column(name = "id_horario", nullable = false)
    private Integer idHorario;

    @Column(name = "horario")
    private String horario;


    @OneToMany (mappedBy = "horarioIdHorario")
    private List<Reservacion> reservacionList;

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public List<Reservacion> getReservacionList() {
        return reservacionList;
    }

    public void setReservacionList(List<Reservacion> reservacionList) {
        this.reservacionList = reservacionList;
    }
}
