package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Basic(optional = false)
    @Column(name = "id_cliente", nullable = false)
    private Integer idCliente;

    @Column(name = "antiguedad_meses")
    private String antiguedadMeses;

    //fk para persona
    @Column(name = "persona_id_persona")
    private Integer personaIdPersona;

    //fk hacia reservacion
    @OneToMany(mappedBy = "clienteIdCliente")
    private List<Reservacion> reservacionList;

    public List<Reservacion> getReservacionList() {
        return reservacionList;
    }

    public void setReservacionList(List<Reservacion> reservacionList) {
        this.reservacionList = reservacionList;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getAntiguedadMeses() {
        return antiguedadMeses;
    }

    public void setAntiguedadMeses(String antiguedadMeses) {
        this.antiguedadMeses = antiguedadMeses;
    }

    public Integer getPersonaIdPersona() {
        return personaIdPersona;
    }

    public void setPersonaIdPersona(Integer personaIdPersona) {
        this.personaIdPersona = personaIdPersona;
    }
}
