package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "horario")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "id_horario", nullable = false)
    private Integer idHorario;

    @Column(name = "horario")
    private Date horario;


    @OneToMany (mappedBy = "hoarioIdHorario")
    private List<Reservacion> reservacionList;

    public List<Reservacion> getReservacionList() {
        return reservacionList;
    }

    public void setReservacionList(List<Reservacion> reservacionList) {
        this.reservacionList = reservacionList;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }
}
