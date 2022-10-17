package com.umg.proyectoDB1.service;

import com.umg.proyectoDB1.entity.*;
import com.umg.proyectoDB1.repository.EstadoRepository;
import com.umg.proyectoDB1.repository.HistorialRepository;
import com.umg.proyectoDB1.repository.RolRepository;
import com.umg.proyectoDB1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/login")
@CrossOrigin

public class LoginService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    HistorialRepository historialRepository;

    @Autowired
    RolRepository rolRepository;

   public int estadoError = 1;
   public int estadoOk = 0;
   public int estadoActivo = 1;



    //login
    @PostMapping(path = "/autenticacion")
    private Login Authentication(@RequestBody Usuario usuario) {
        int longitud = usuarioRepository.findByUsuarioAndPassword(usuario.getUsuario(), usuario.getPassword()).size();

        if (usuario.getUsuario() == null || usuario.getPassword() == null || usuario.getUsuario().isEmpty() || usuario.getPassword().isEmpty()) {
           //si los parametros son erroneos
            Login login = new Login();
            login.setCodError(estadoError);
            login.setMensage("Parametros invalidos");
            return login;

        } else if (usuario.getUsuario().equals("admin") && usuario.getPassword().equals("21232f297a57a5a743894a0e4a801fc3")) {
            //si es Admin
            Login login = new Login();
            login.setCodError(estadoOk);
            login.setUsuario(usuario.getUsuario());
            login.setPassword(usuario.getPassword());
            login.setEstado("Activo");
            login.setMensage("Usuario es Admin");
            login.setRol(0);
            return login;

        } else if (longitud > 0) {
            Optional<Usuario> datosUsuario = usuarioRepository.findByUsuario(usuario.getUsuario());

            int estadoUsuario = datosUsuario.get().getIdUsuario();
            int estadoNew = validaEstado(estadoUsuario, 1);

            if (estadoNew == 1) {
                Login login = new Login();
                login.setUsuario(usuario.getUsuario());
                login.setCodError(estadoOk);
                login.setPassword(usuario.getPassword());
                login.setMensage("¡bienvenido!");
                //pendientes
                login.setRol(1);
                login.setEstado(EstadoValor(estadoNew));
                login.setRol(datosUsuario.get().getIdUsuario());
                return login;
            }
        }
        else {
            Login login = new Login();
            login.setUsuario(null);
            login.setCodError(estadoError);
            login.setEstado("Error usuario no existe o estado no valido");
            login.setPassword(usuario.getPassword());
            return login;
        }
        return new Login();
    }



    @GetMapping(path = "/consultaEstado")
    private List<Estado> estadostest(){
        return estadoRepository.findAll();
    }


    //busca usuario
    public Optional<Usuario> busca(Usuario usuario){
        return usuarioRepository.findByUsuario(usuario.getUsuario());
    }

    //devuelve el valor del Rol
    public int RolValor (int idUsuario){
        Optional<Historial> rol = historialRepository.findById(idUsuario);
        return rol.get().getRolIdRol();
    }

    //devuelve el valor del Estado
    public String EstadoValor ( int idEstado){
        Optional<Estado> estados = estadoRepository.findById(idEstado);
        return estados.get().getNombreEstado();
    }

    //encuentra el historial
    public Optional<Historial> historial( int idUsuario){
        Optional<Historial> historial = historialRepository.findById(idUsuario);
        return historial;
    }

    public int validaEstado(int usuario, int estado) {
        int valor = buscaEstado(estado, usuario);
        return  historial(valor).get().getEstadoIdEstado();
    }

    public int buscaEstado(int idusuario, int estado) {
        List<Historial> historial = historialRepository.findHistorialByEstadoIdEstadoAndUsuarioIdUsuarioOrderByIdHistorial(estado, idusuario);
        int cont = 0;
        for (Historial historia : historial) {
            if (historia.getIdHistorial() > cont) {
                cont = historia.getIdHistorial();
            } else {
                cont = historia.getIdHistorial();
                return cont;
            }
        }
        return cont;
    }

}
