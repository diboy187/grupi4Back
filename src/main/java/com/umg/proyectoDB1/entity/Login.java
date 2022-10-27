package com.umg.proyectoDB1.entity;

public class Login {


    int CodError;
    int Rol;
    String usuario;
    String mensaje;
    String estado;
    String password;

    int idCliente;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
