package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {

    private static final long serialVersionUID = 3760988163877761705L;
    @Id
    @Column(name = "id_persona")
    private Integer idPersona;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "telefono")
    private Integer telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "nit")
    private String nit;

    @Column(name = "identidad")
    private String identidad;

    // llaves foraneas
    @Column(name = "tipo_Identidad_id_tipo_identidad")
    private Integer tipoIdentidadIdTipoIdentidad;
    @Column(name = "direccion_id_direccion")
    private Integer direccionIdDireccion;

    //relacion a otras tablas
    @OneToMany(mappedBy = "personaIdPersona")
    private List<Cliente> clienteList;

    @OneToMany(mappedBy = "personaIdPersona")
    private List<Usuario> usuarioList;

    @OneToMany(mappedBy = "especialidad")
    private List<Especialidad> especialidadList;

    public Persona(){}
    public Persona(Integer idPersona, String nombre, String apellido, Integer edad, Integer telefono, String email, String nit, String identidad) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.nit = nit;
        this.identidad = identidad;
    }

    public List<Especialidad> getEspecialidadList() {
        return especialidadList;
    }

    public void setEspecialidadList(List<Especialidad> especialidadList) {
        this.especialidadList = especialidadList;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public int getTipoIdentidadIdTipoIdentidad() {
        return tipoIdentidadIdTipoIdentidad;
    }


    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setTipoIdentidadIdTipoIdentidad(Integer tipoIdentidadIdTipoIdentidad) {
        this.tipoIdentidadIdTipoIdentidad = tipoIdentidadIdTipoIdentidad;
    }

    public Integer getDireccionIdDireccion() {
        return direccionIdDireccion;
    }

    public void setDireccionIdDireccion(Integer direccionIdDireccion) {
        this.direccionIdDireccion = direccionIdDireccion;
    }
}
