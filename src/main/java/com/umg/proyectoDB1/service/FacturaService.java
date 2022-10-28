package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.*;
import com.umg.proyectoDB1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

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

    @Autowired
    TerapiaRepository terapiaRepository;

    @Autowired
    FacturaTipoPagoRepository facturaTipoPagoRepository;

    @GetMapping(path = "/consulta")
    private List<Factura> consulta(){
        return facturaRepository.findAll();
    }

    @GetMapping(path = "/detalle/{id}")
    private ArrayList consultaDetalle(@PathVariable ("id") Integer id){

        Optional<DetalleFactura> detalleFactura = detalleFacturaRepository.findById(id);
        Optional<TerapiaReservacion> terapiaReservacion = terapiaReservacionRepository.findById(detalleFactura.get().getTerpaiaReservacionIdTerapiaReservacion());
        Optional<Reservacion> reservacion = reservacionRepository.findById(terapiaReservacion.get().getReservacionIdReservacion());
        Optional<Horario> horario = horarioRepository.findById(reservacion.get().getHorarioIdHorario());
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

    @PostMapping(path = "/crea/{id}")
    private Optional<Factura> crea(@PathVariable ("id") Integer tipoPago, @RequestBody List<TerapiaReservacion> terapiaReservacionList){

        FacturaTipoPago facturaTipoPago = creaFacturaTipoPago(terapiaReservacionList, tipoPago);
        Factura factura = creaFactura(facturaTipoPago.getIdFacturaTipoPago());
        creaDetalleFactura(terapiaReservacionList, factura.getIdFactura());
        return facturaRepository.findById(factura.getIdFactura());
    }

    private FacturaTipoPago creaFacturaTipoPago(List<TerapiaReservacion> terapiaReservacionList,int tipoPago){
        Double cantidad = 0.00;
        List<Terapia> terapiaList = terapiaRepository.findAll();
        for(TerapiaReservacion terapiaReservacion : terapiaReservacionList){
            for(Terapia terapia : terapiaList){
                if(terapiaReservacion.getTerapiaIdTerapia() == terapia.getIdTerapia()){
                    cantidad += terapia.getPrecio();
                }
            }
        }

        Date fecha = new Date();

        int idFacturaTipoPago = facturaTipoPagoRepository.findAll().size();
        idFacturaTipoPago++;

        FacturaTipoPago facturaTipoPago = new FacturaTipoPago();
        facturaTipoPago.setIdFacturaTipoPago(idFacturaTipoPago);
        facturaTipoPago.setCantidad(cantidad);
        facturaTipoPago.setTipoPagoIdtipoPago(tipoPago);
        facturaTipoPago.setFecha(fecha);

        return facturaTipoPagoRepository.save(facturaTipoPago);
    }

    private Factura creaFactura(int facturaTipoPago){
        int idFactura = facturaRepository.findAll().size();
        idFactura++;
        String serie = "A";
        int estado = 3;

        Factura factura = new Factura();
        factura.setIdFactura(idFactura);
        factura.setNumeroFactura(idFactura);
        factura.setSerieFactura(serie);
        factura.setEstadoIdEstado(estado);
        factura.setFacturaTipoPagoIdFacturaTipoPago(facturaTipoPago);
        return facturaRepository.save(factura);
    }

    private void creaDetalleFactura(List<TerapiaReservacion> terapiaReservacionList, int idFactura){

        int idDetalleFactura = detalleFacturaRepository.findAll().size();
        idDetalleFactura++;
//        List<DetalleFactura> detalleFacturaListReturn = new ArrayList<>();

        for(TerapiaReservacion terapiaReservacion: terapiaReservacionList){
            DetalleFactura detalleFactura = new DetalleFactura();

            detalleFactura.setIdDetalleFactura(idDetalleFactura);
            detalleFactura.setFacturaIdFactura(idFactura);
            detalleFactura.setTerpaiaReservacionIdTerapiaReservacion(terapiaReservacion.getIdTerapiaReservacion());
//            detalleFacturaListReturn.add(detalleFactura);
            detalleFacturaRepository.save(detalleFactura);
            idFactura++;
        }

    }


}
