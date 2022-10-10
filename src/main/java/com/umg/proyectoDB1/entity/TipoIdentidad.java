package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipo_identidad")
public class TipoIdentidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "id_tipo_identidad")
    private Integer idTipoIdentidad;

    @Column(name = "tipo_identidad")
    private String tipoIdentidad;

    @OneToMany(mappedBy = "tipoIdentidadIdTipoIdentidad")
    private List<Persona> personaList;



    public Integer getIdTipoIdentidad() {
        return idTipoIdentidad;
    }

    public void setIdTipoIdentidad(Integer idTipoIdentidad) {
        this.idTipoIdentidad = idTipoIdentidad;
    }

    public String getTipoIdentidad() {
        return tipoIdentidad;
    }

    public void setTipoIdentidad(String tipoIdentidad) {
        this.tipoIdentidad = tipoIdentidad;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }
}
