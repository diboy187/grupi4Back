package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "clinica")
public class Clinica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idclinica", nullable = false)
    private Integer idclinica;

    @Column(name = "clinica")
    private String clinica;

    public Clinica(){}
    public Clinica(Integer idclinica, String clinica) {
        this.idclinica = idclinica;
        this.clinica = clinica;
    }

    public Integer getIdclinica() {
        return idclinica;
    }

    public void setIdclinica(Integer idclinica) {
        this.idclinica = idclinica;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }
}
