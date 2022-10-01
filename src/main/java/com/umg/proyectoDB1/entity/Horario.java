package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.lang.annotation.Native;

@Entity
@Table(name = "horario")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idhorario", nullable = false)
    private Integer idhorario;

    @Column(name = "horario")
    private String horario;

    public Horario(){}
    public Horario(Integer idhorario, String horario) {
        this.idhorario = idhorario;
        this.horario = horario;
    }

    public Integer getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
