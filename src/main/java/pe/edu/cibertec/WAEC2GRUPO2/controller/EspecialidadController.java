package pe.edu.cibertec.WAEC2GRUPO2.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.WAEC2GRUPO2.model.bd.Especialidad;
import pe.edu.cibertec.WAEC2GRUPO2.model.bd.Medico;
import pe.edu.cibertec.WAEC2GRUPO2.model.dto.request.EspecialidadRequest;
import pe.edu.cibertec.WAEC2GRUPO2.model.dto.response.ResultadoResponse;
import pe.edu.cibertec.WAEC2GRUPO2.service.IEspecialidadService;

import java.util.List;

@Controller
@RequestMapping("/especialidad")
@AllArgsConstructor
public class EspecialidadController {
    private IEspecialidadService iEspecialidadService;

    @GetMapping("")
    public String frmespecialidad(Model model){
        model.addAttribute("listaEspecialidades", iEspecialidadService.listarEspecialidades());
        return "backoffice/especialidad/frmespecialidad";
    }

    @GetMapping("/lista")
    @ResponseBody
    public List<Especialidad> listarEspecialidades(){
        return iEspecialidadService.listarEspecialidades();
    }

    @GetMapping("/obtener/{idespecialidad}")
    @ResponseBody
    public Especialidad obtenerEspecialidadPorId(@PathVariable("idespecialidad") Integer idespecialidad){
        return iEspecialidadService.buscarPorId(idespecialidad);
    }

    @PostMapping("/registro")
    @ResponseBody
    public ResultadoResponse registrarEspecialidad(@RequestBody EspecialidadRequest especialidadRequest){
        String mensaje = "Especialidad registrada con éxito";
        boolean respuesta = true;
        try{
            Especialidad especialidad = new Especialidad();
            especialidad.setTitulo(especialidadRequest.getTitulo());
            especialidad.setFuncion(especialidadRequest.getFuncion());
            especialidad.setFechgraduacion(especialidadRequest.getFechgraduacion());
            Medico medico = new Medico();
            medico.setIdmedico(especialidadRequest.getIdmedico());
            especialidad.setMedico(medico);
            iEspecialidadService.registrarEspecialidad(especialidad);
        } catch(Exception ex){
            mensaje = "Error: " + ex.getMessage();
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    @PutMapping("/actualizacion")
    @ResponseBody
    public ResultadoResponse actualizarEspecialidad(@RequestBody EspecialidadRequest especialidadRequest){
        String mensaje = "Especialidad actualizada con éxito";
        boolean respuesta = true;
        try{
            Especialidad especialidad = new Especialidad();
            especialidad.setIdespecialidad(especialidadRequest.getIdespecialidad());
            especialidad.setTitulo(especialidadRequest.getTitulo());
            especialidad.setFuncion(especialidadRequest.getFuncion());
            especialidad.setFechgraduacion(especialidadRequest.getFechgraduacion());
            Medico medico = new Medico();
            medico.setIdmedico(especialidadRequest.getIdmedico());
            especialidad.setMedico(medico);
            iEspecialidadService.registrarEspecialidad(especialidad);
        } catch(Exception ex){
            mensaje = "Error: " + ex.getMessage();
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    @DeleteMapping("/eliminacion/{idespecialidad}")
    @ResponseBody
    public ResultadoResponse eliminarEspecialidad(@PathVariable("idespecialidad") Integer idespecialidad){
        String mensaje = "Especialidad eliminada con éxito";
        boolean respuesta = true;
        try{
            iEspecialidadService.eliminarEspecialidad(idespecialidad);
        } catch(Exception ex){
            mensaje = "Error: " + ex.getMessage();
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
