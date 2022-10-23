package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @Column(name = "id_menu", nullable = false)
    private Integer idMenu;

    @Column(name = "nombre_menu")
    private String nombreMenu;

    @OneToMany(mappedBy = "menuIdMenu")
    private List<MenuRol> menuRolList;

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public List<MenuRol> getMenuRolList() {
        return menuRolList;
    }

    public void setMenuRolList(List<MenuRol> menuRolList) {
        this.menuRolList = menuRolList;
    }
}
