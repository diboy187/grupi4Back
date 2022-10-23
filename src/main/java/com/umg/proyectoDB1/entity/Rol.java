package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @Column(name = "id_rol", nullable = false)
    private Integer idRol;

    @Column(name = "nombre_rol")
    private String nombreRol;

    @Column(name = "crear")
    private Integer crear;

    @Column(name = "borrar")
    private Integer borrar;

    @Column(name = "actualizar")
    private Integer actualizar;

    @Column(name = "consultar")
    private Integer consultar;


    @OneToMany(mappedBy = "rolIdRol")
    private List<Historial> historialList;

    @OneToMany(mappedBy = "menuIdMenu")
    private List<MenuRol> menuRolList;

    public List<Historial> getHistorialList() {
        return historialList;
    }

    public void setHistorialList(List<Historial> historialList) {
        this.historialList = historialList;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Integer getCrear() {
        return crear;
    }

    public void setCrear(Integer crear) {
        this.crear = crear;
    }

    public Integer getBorrar() {
        return borrar;
    }

    public void setBorrar(Integer borrar) {
        this.borrar = borrar;
    }

    public Integer getActualizar() {
        return actualizar;
    }

    public void setActualizar(Integer actualizar) {
        this.actualizar = actualizar;
    }

    public Integer getConsultar() {
        return consultar;
    }

    public void setConsultar(Integer consultar) {
        this.consultar = consultar;
    }

    public List<MenuRol> getMenuRolList() {
        return menuRolList;
    }

    public void setMenuRolList(List<MenuRol> menuRolList) {
        this.menuRolList = menuRolList;
    }
}
