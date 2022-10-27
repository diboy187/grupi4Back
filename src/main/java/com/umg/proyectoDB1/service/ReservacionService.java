package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.Reservacion;
import com.umg.proyectoDB1.repository.ReservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("reservacion")
@CrossOrigin
public class ReservacionService {

    @Autowired
    ReservacionRepository reservacionRepository;

    @GetMapping(path = "/consulta")
    private List<Reservacion> consulta() {
        return reservacionRepository.findAll();
    }


    @PostMapping(path = "/crea")
    private Reservacion cambio(@RequestBody Reservacion reservacion) {

        int id = reservacionRepository.findAll().size();
        id++;
        reservacion.setIdReservacion(id);
        System.out.println("id reservacion -> " + reservacion.getIdReservacion());
        return reservacionRepository.save(reservacion);
    }


    @GetMapping(path = "/modifica/{id}/{estado}")
    private String modifica(@PathVariable("id") Integer id, @PathVariable("estado") Integer estado) {
        Optional<Reservacion> reservacion = reservacionRepository.findById(id);
        boolean esta = reservacion.isPresent();
        reservacion.get().setEstadoIdEstado(estado);
        if (esta) {
            Optional<Reservacion> reservacionNueva = reservacionRepository.findById(id);
            if (validaFecha(reservacionNueva, id)) {
                ArrayList<Optional<Reservacion>> reservacions = new ArrayList<>();
                reservacions.add(reservacionNueva);
               return "1 Si se puede cambiar";
            } else {
                return "0 No se puede cambiar";
            }
        }
        return "Error algo no esta dentro de la logica";
    }


    private Boolean validaFecha(Optional<Reservacion> reservacion, int id) {
        Boolean factible = false;
        int valor = 0;
        Optional<Reservacion> reservaciontmp = reservacionRepository.findById(id);

        String fechaActual = DateTimeFormatter.ofPattern("yyyy-MM-dd ").format(LocalDateTime.now());
        Date fechatemp = reservacion.get().getFechaRerservacion();

        System.out.println("fecha Actual -> " + fechaActual);
        System.out.println("fecha peticion -> " + fechatemp);
        int fechaAnio = Integer.parseInt(String.valueOf(fechaActual).substring(0, 4));
        int fechaMes = Integer.parseInt(String.valueOf(fechaActual).substring(5, 7));
        int fechaDia = Integer.parseInt(String.valueOf(fechaActual).substring(8, 10));

        int fechaAnioP = Integer.parseInt(String.valueOf(fechatemp).substring(0, 4));
        int fechaMesP = Integer.parseInt(String.valueOf(fechatemp).substring(5, 7));
        int fechaDiaP = Integer.parseInt(String.valueOf(fechatemp).substring(8, 10));

        System.out.println("anio peticion -> " + fechaAnioP + " anio actual -> " + fechaAnio);
        System.out.println("mes peticion -> " + fechaMesP + " mes actual -> " + fechaMes);
        System.out.println("dia peticion -> " + fechaDiaP + " dia actual -> " + fechaDia);

        if (fechaAnioP == fechaAnio) {
            if (fechaMesP == fechaMes) {
                if (fechaDiaP < fechaDia) {
                    System.out.println(" si se puede");
                    return factible = true;
                } else {
                    System.out.println(" No se puede");
                    return factible = false;
                }
            } else {
                if (fechaMesP < fechaMes) {
                    System.out.println(" si se puede");
                    return factible = true;
                } else {
                    System.out.println(" No se puede");
                    return factible = false;
                }
            }
        } else if (fechaAnioP < fechaAnio) {
            System.out.println(" si se puede");
            return factible = true;
        }
        System.out.println("No anio mayor al registrado");
        return factible = false;
    }
}