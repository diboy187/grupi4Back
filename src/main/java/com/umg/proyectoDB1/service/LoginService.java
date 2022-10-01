package com.umg.proyectoDB1.service;
import com.umg.proyectoDB1.entity.Login;
import com.umg.proyectoDB1.entity.Persona;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")
@CrossOrigin

public class LoginService {

//    @Autowired
//    UserRepository userRepository;

    //Autentica al usuario y devuelve la información general de la persona
    @PostMapping(path = "/login")
    private Persona loginTeacher(@RequestBody Login credentials) {
//        return userRepository.findByUserAndPassword(credentials.getUser(), credentials.getPass());
        Persona persona = new Persona();
        if(credentials.getUser().equals("admin") && credentials.getPass().equals("admin")){
            persona.setIdPersona(1);
        }


        return persona;
    }

}
