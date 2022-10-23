package com.umg.proyectoDB1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_rol")
public class MenuRol {
    @Id
    @Column(name = "id_menu_rol", nullable = false)
    private Integer idMenuRol;

    @Column(name = "menu_id_menu")
    private Integer menuIdMenu;

    @Column(name = "rol_id_rol")
    private Integer rolIdRol;

    public Integer getIdMenuRol() {
        return idMenuRol;
    }

    public void setIdMenuRol(Integer idMenuRol) {
        this.idMenuRol = idMenuRol;
    }

    public Integer getMenuIdMenu() {
        return menuIdMenu;
    }

    public void setMenuIdMenu(Integer menuIdMenu) {
        this.menuIdMenu = menuIdMenu;
    }

    public Integer getRolIdRol() {
        return rolIdRol;
    }

    public void setRolIdRol(Integer rolIdRol) {
        this.rolIdRol = rolIdRol;
    }
}
