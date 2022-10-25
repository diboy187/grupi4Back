package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.*;
import com.umg.proyectoDB1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("factura")
@CrossOrigin
public class FacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    DetalleFacturaRepository detalleFacturaRepository;

    @Autowired
    TerapiaReservacionRepository terapiaReservacionRepository;

    @Autowired
    ReservacionRepository reservacionRepository;

    @Autowired
    HorarioRepository horarioRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    EspecialidadEspecialistaRepository especialidadEspecialistaRepository;

    @Autowired
    EspecialistaRepository especialistaRepository;

    @Autowired
    ClinicaEspecialidadRepository clinicaEspecialidadRepository;

    @Autowired
    ClinicaRepository clinicaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    SedeRepository sedeRepository;

    @GetMapping(path = "/consulta")
    private List<Factura> consulta(){
        return facturaRepository.findAll();
    }

    @GetMapping(path = "/detalle/{id}")
    private ArrayList consultaDetalle(@PathVariable ("id") Integer id){

        Optional<DetalleFactura> detalleFactura = detalleFacturaRepository.findById(id);
        Optional<TerapiaReservacion> terapiaReservacion = terapiaReservacionRepository.findById(detalleFactura.get().getTerpaiaReservacionIdTerapiaReservacion());
        Optional<Reservacion> reservacion = reservacionRepository.findById(terapiaReservacion.get().getReservacionIdReservacion());
        Optional<Horario> horario = horarioRepository.findById(reservacion.get().getHoarioIdHorario());
        Optional<Estado> estado = estadoRepository.findById(reservacion.get().getEstadoIdEstado());
        Optional<EspecialidadEspecialista> especialidadEspecialista = especialidadEspecialistaRepository.findById(reservacion.get().getEspecialidadEspecialistaIdEspecialidadEspecialista());
        Optional<Especialista> especialista = especialistaRepository.findById(especialidadEspecialista.get().getEspecialistaIdEspecialista());
        Optional<Persona> personaEspecialista = personaRepository.findById(especialista.get().getPersonaIdPersona());
        Optional<ClinicaEspecialidad> clinicaEspecialidad = clinicaEspecialidadRepository.findById(reservacion.get().getClinicaEspecialidadIdClinicaEspecialidad());
        Optional<Clinica> clinica = clinicaRepository.findById(clinicaEspecialidad.get().getClinicaIdClinica());
        Optional<Sede> sede = sedeRepository.findById(clinica.get().getSedeIdSede());
        Optional<Cliente> cliente = clienteRepository.findById(reservacion.get().getClienteIdCliente());
        Optional<Persona> personaCliente = personaRepository.findById(cliente.get().getPersonaIdPersona());

        ArrayList detalle = new ArrayList();
        detalle.add(reservacion);
        detalle.add(horario);
        detalle.add(estado);
        detalle.add(sede);
        detalle.add(clinica);
        detalle.add(personaEspecialista);
        detalle.add(personaCliente);

        return detalle;
    }


}
