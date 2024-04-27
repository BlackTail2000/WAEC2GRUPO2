package pe.edu.cibertec.WAEC2GRUPO2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/especialidad")
public class EspecialidadController {

    @GetMapping("")
    public String frmespecialidad(){
        return "backoffice/especialidad/frmespecialidad";
    }
}
