package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "especialidad_especialista")
public class EspecialidadEspecialista {
    @Id
    @Column(name = "id_especialidad_especialista", nullable = false)
    private Integer idEspecialidadEspecialista;

    @Column(name = "especialidad_id_especialidad")
    private Integer especialidadIdEspecialidad;

    @Column(name = "especialista_id_especialista")
    private Integer especialistaIdEspecialista;


    @OneToMany (mappedBy = "especialidadEspecialistaIdEspecialidadEspecialista")
    private List<Reservacion> reservacionList;

    public List<Reservacion> getReservacionList() {
        return reservacionList;
    }

    public void setReservacionList(List<Reservacion> reservacionList) {
        this.reservacionList = reservacionList;
    }

    public Integer getIdespecialidadEspecialista() {
        return idEspecialidadEspecialista;
    }

    public void setIdespecialidadEspecialista(Integer idespecialidadEspecialista) {
        this.idEspecialidadEspecialista = idespecialidadEspecialista;
    }

    public Integer getEspecialidadIdEspecialidad() {
        return especialidadIdEspecialidad;
    }

    public void setEspecialidadIdEspecialidad(Integer especialidadIdEspecialidad) {
        this.especialidadIdEspecialidad = especialidadIdEspecialidad;
    }

    public Integer getEspecialistaIdEspecialista() {
        return especialistaIdEspecialista;
    }

    public void setEspecialistaIdEspecialista(Integer especialistaIdEspecialista) {
        this.especialistaIdEspecialista = especialistaIdEspecialista;
    }
}
