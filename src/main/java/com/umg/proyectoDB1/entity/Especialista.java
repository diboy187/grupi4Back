package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "especialista")
public class Especialista {
    @Id
    @Column(name = "id_especialista", nullable = false)
    private Integer idEspecialista;

    //fk de estado especialista
    @Column(name = "estado_especialista")
    private Integer estadoEspecialista;

    //fk de persona
    @Column(name = "persona_id_persona")
    private Integer personaIdPersona;


    @OneToMany(mappedBy = "especialidadIdEspecialidad")
    private List<EspecialidadEspecialista> especialidadEspecialistaList;



    public List<EspecialidadEspecialista> getEspecialidadEspecialistaList() {
        return especialidadEspecialistaList;
    }

    public void setEspecialidadEspecialistaList(List<EspecialidadEspecialista> especialidadEspecialistaList) {
        this.especialidadEspecialistaList = especialidadEspecialistaList;
    }

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
