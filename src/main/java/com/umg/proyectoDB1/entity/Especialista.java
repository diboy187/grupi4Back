package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "estilo")
public class Especialista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idespecialista", nullable = false)
    private Integer idespecialista;

    @Column(name = "estadoEspecialista")
    private Character estadoEspecialista;

    public Especialista(){}
    public Especialista(Integer idespecialista, Character estadoEspecialista) {
        this.idespecialista = idespecialista;
        this.estadoEspecialista = estadoEspecialista;
    }

    public Integer getIdespecialista() {
        return idespecialista;
    }

    public void setIdespecialista(Integer idespecialista) {
        this.idespecialista = idespecialista;
    }

    public Character getEstadoEspecialista() {
        return estadoEspecialista;
    }

    public void setEstadoEspecialista(Character estadoEspecialista) {
        this.estadoEspecialista = estadoEspecialista;
    }
}
