package com.umg.proyectoDB1.entity;

public class Login {


    int CodError;
    int Rol;
    String usuario;
    String mensage;
    String estado;
    String password;

    public Login(){}
    public Login(int codError, int rol, String usuario, String mensage, String estado, String password) {
        CodError = codError;
        Rol = rol;
        this.usuario = usuario;
        this.mensage = mensage;
        this.estado = estado;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCodError() {
        return CodError;
    }

    public void setCodError(int codError) {
        CodError = codError;
    }

    public int getRol() {
        return Rol;
    }

    public void setRol(int rol) {
        Rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
