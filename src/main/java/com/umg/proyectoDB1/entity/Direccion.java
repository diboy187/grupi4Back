package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "id_direccion", nullable = false)
    private Integer idDireccion;

    @Column(name = "calle")
    private String calle;

    @Column(name = "avenida")
    private String avenida;

    @Column(name = "otros")
    private String otros;

    @Column(name = "municipio_id_municipio")
    private int municipioIdMunicipio;

    @OneToMany(mappedBy ="direccionIdDireccion" )
    private List<Sede> sedeList;

    @OneToMany(mappedBy = "direccionIdDireccion")
    private List<Persona> personaList;

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getAvenida() {
        return avenida;
    }

    public void setAvenida(String avenida) {
        this.avenida = avenida;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public int getMunicipioIdMunicipio() {
        return municipioIdMunicipio;
    }

    public void setMunicipioIdMunicipio(int municipioIdMunicipio) {
        this.municipioIdMunicipio = municipioIdMunicipio;
    }

    public List<Sede> getSedeList() {
        return sedeList;
    }

    public void setSedeList(List<Sede> sedeList) {
        this.sedeList = sedeList;
    }
}
