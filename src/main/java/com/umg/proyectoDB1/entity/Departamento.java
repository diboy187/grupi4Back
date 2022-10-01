package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "iddepartamento", nullable = false)
    private Integer iddepartamento;

    @Column(name = "departamento")
    private String departamento;

    public Departamento(){}
    public Departamento(Integer iddepartamento, String departamento) {
        this.iddepartamento = iddepartamento;
        this.departamento = departamento;
    }

    public Integer getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(Integer iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
