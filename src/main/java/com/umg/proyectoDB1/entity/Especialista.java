package com.umg.proyectoDB1.entity;

import javax.persistence.*;

@Entity
@Table(name = "especialista")
public class Especialista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "id_especialista", nullable = false)
    private Integer idEspecialista;

    @Column(name = "estado_especialista")
    private Integer estadoEspecialista;

    @Column(name = "persona_id_persona")
    private Integer personaIdPersona;

    public Integer getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(Integer idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    public Integer getEstadoEspecialista() {
        return estadoEspecialista;
    }

    public void setEstadoEspecialista(Integer estadoEspecialista) {
        this.estadoEspecialista = estadoEspecialista;
    }

    public Integer getPersonaIdPersona() {
        return personaIdPersona;
    }

    public void setPersonaIdPersona(Integer personaIdPersona) {
        this.personaIdPersona = personaIdPersona;
    }
}
