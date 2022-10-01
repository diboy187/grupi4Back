package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "Sede")
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idsede", nullable = false)
    private Integer idsede;

    @Column(name = "sede")
    private String sede;

    public Sede(){}
    public Sede(Integer idsede, String sede) {
        this.idsede = idsede;
        this.sede = sede;
    }

    public Integer getIdsede() {
        return idsede;
    }

    public void setIdsede(Integer idsede) {
        this.idsede = idsede;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }
}
