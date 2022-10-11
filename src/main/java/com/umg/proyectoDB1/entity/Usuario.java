package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "password")
    private String password;

    @Column(name = "persona_id_persona")
    private Integer personaIdPersona;

    @OneToMany(mappedBy = "usuarioIdUsuario")
    private List<Historial> historialList;

    public List<Historial> getHistorialList() {
        return historialList;
    }

    public void setHistorialList(List<Historial> historialList) {
        this.historialList = historialList;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPersonaIdPersona() {
        return personaIdPersona;
    }

    public void setPersonaIdPersona(Integer personaIdPersona) {
        this.personaIdPersona = personaIdPersona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
