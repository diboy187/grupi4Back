package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "persona")
public class Persona {

    private static final long serialVersionUID = 3760988163877761705L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "idPersona")
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

    @Column(name = "identidad")
            private String identidad;

    @Column(name = "tipoIdentidadIdTipoIdentidad")
    private Integer tipoIdentidadIdTipoIdentidad;

    public Persona() {}
    public Persona(Integer idPersona, String nombre, String apellido, Integer edad, Integer telefono, String email, String identidad) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.identidad = identidad;
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
}
