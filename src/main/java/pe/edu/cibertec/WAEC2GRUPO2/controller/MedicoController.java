package pe.edu.cibertec.WAEC2GRUPO2.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.WAEC2GRUPO2.model.bd.Medico;
import pe.edu.cibertec.WAEC2GRUPO2.service.IMedicoService;

import java.util.List;

@Controller
@RequestMapping("/medico")
@AllArgsConstructor
public class MedicoController {
    private IMedicoService iMedicoService;

    @GetMapping("/lista")
    @ResponseBody
    public List<Medico> listarMedicosOrdenadosPorApellido(){
        return iMedicoService.listarMedicosOrdenadosPorApellido();
    }
}
