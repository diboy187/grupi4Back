package com.umg.proyectoDB1.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservacion")
public class Reservacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)

    @Column(name = "id_reservacion", nullable = false)
    private Integer idReservacion;

    @Column(name = "datos_reservacion")
    private String datosReservacion;

    @Column(name = "fecha_Rerservacion")
    private Date fechaRerservacion;

    @Column(name = "horario_id_horario")
    private Integer hoarioIdHorario;

    @Column(name = "cliente_id_cliente")
    private Integer clienteIdCliente;

    @Column(name = "estado_id_estado")
    private Integer estadoIdEstado;

    @Column(name = "especialidad_especialista_id_especialidad_especialista")
    private Integer especialidadEspecialistaIdEspecialidadEspecialista;

    @Column(name = "clinica_especialidad_id_clinica_especialidad")
    private Integer clinicaEspecialidadIdClinicaEspecialidad;

    public Integer getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(Integer idReservacion) {
        this.idReservacion = idReservacion;
    }

    public String getDatosReservacion() {
        return datosReservacion;
    }

    public void setDatosReservacion(String datosReservacion) {
        this.datosReservacion = datosReservacion;
    }

    public Date getFechaRerservacion() {
        return fechaRerservacion;
    }

    public void setFechaRerservacion(Date fechaRerservacion) {
        this.fechaRerservacion = fechaRerservacion;
    }

    public Integer getHoarioIdHorario() {
        return hoarioIdHorario;
    }

    public void setHoarioIdHorario(Integer hoarioIdHorario) {
        this.hoarioIdHorario = hoarioIdHorario;
    }

    public Integer getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(Integer clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    public Integer getEstadoIdEstado() {
        return estadoIdEstado;
    }

    public void setEstadoIdEstado(Integer estadoIdEstado) {
        this.estadoIdEstado = estadoIdEstado;
    }

    public Integer getEspecialidadEspecialistaIdEspecialidadEspecialista() {
        return especialidadEspecialistaIdEspecialidadEspecialista;
    }

    public void setEspecialidadEspecialistaIdEspecialidadEspecialista(Integer especialidadEspecialistaIdEspecialidadEspecialista) {
        this.especialidadEspecialistaIdEspecialidadEspecialista = especialidadEspecialistaIdEspecialidadEspecialista;
    }

    public Integer getClinicaEspecialidadIdClinicaEspecialidad() {
        return clinicaEspecialidadIdClinicaEspecialidad;
    }

    public void setClinicaEspecialidadIdClinicaEspecialidad(Integer clinicaEspecialidadIdClinicaEspecialidad) {
        this.clinicaEspecialidadIdClinicaEspecialidad = clinicaEspecialidadIdClinicaEspecialidad;
    }
}
