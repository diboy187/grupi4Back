package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Basic(optional = false)
    @Column(name = "id_cliente", nullable = false)
    private Integer idCliente;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

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

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getPersonaIdPersona() {
        return personaIdPersona;
    }

    public void setPersonaIdPersona(Integer personaIdPersona) {
        this.personaIdPersona = personaIdPersona;
    }
}
