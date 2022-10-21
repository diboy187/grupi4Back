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
    @Column(name = "estado_id_estado")
    private Integer estadoIdEstado;

    //fk de persona
    @Column(name = "persona_id_persona")
    private Integer personaIdPersona;


  /*  @OneToMany(mappedBy = "especialistaIdEspecialista")
    private List<EspecialidadEspecialista> especialidadEspecialistaList;
*/
    public Integer getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(Integer idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    public Integer getEstadoIdEstado() {
        return estadoIdEstado;
    }

    public void setEstadoIdEstado(Integer estadoIdEstado) {
        this.estadoIdEstado = estadoIdEstado;
    }

    public Integer getPersonaIdPersona() {
        return personaIdPersona;
    }

    public void setPersonaIdPersona(Integer personaIdPersona) {
        this.personaIdPersona = personaIdPersona;
    }

  /*  public List<EspecialidadEspecialista> getEspecialidadEspecialistaList() {
        return especialidadEspecialistaList;
    }

    public void setEspecialidadEspecialistaList(List<EspecialidadEspecialista> especialidadEspecialistaList) {
        this.especialidadEspecialistaList = especialidadEspecialistaList;
    }*/
}
