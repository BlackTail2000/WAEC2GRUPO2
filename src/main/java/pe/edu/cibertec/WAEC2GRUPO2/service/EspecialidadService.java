package pe.edu.cibertec.WAEC2GRUPO2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.WAEC2GRUPO2.controller.EspecialidadController;
import pe.edu.cibertec.WAEC2GRUPO2.model.bd.Especialidad;
import pe.edu.cibertec.WAEC2GRUPO2.model.bd.Medico;
import pe.edu.cibertec.WAEC2GRUPO2.model.dto.request.EspecialidadRequest;
import pe.edu.cibertec.WAEC2GRUPO2.repository.EspecialidadRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EspecialidadService implements IEspecialidadService {
    private EspecialidadRepository especialidadRepository;

    @Override
    public void registrarEspecialidad(EspecialidadRequest especialidadRequest) throws Exception {
        if(especialidadRequest.getTitulo() == null || especialidadRequest.getTitulo().isEmpty())
            throw new Exception("Ingresar título");
        if(especialidadRequest.getTitulo().length() > 250)
            throw new Exception("Título demasiado largo (Máximo 250 caracteres)");
        if(especialidadRequest.getFuncion() == null || especialidadRequest.getFuncion().isEmpty())
            throw new Exception("Ingresar función");
        if(especialidadRequest.getFuncion().length() > 250)
            throw new Exception("Función demasiado larga (Máximo 250 caracteres)");
        if(especialidadRequest.getFechgraduacion() == null)
            throw new Exception("Ingresar una fecha válida");
        Especialidad especialidad = new Especialidad();
        if(especialidadRequest.getIdespecialidad() > 0)
            especialidad.setIdespecialidad(especialidadRequest.getIdespecialidad());
        especialidad.setTitulo(especialidadRequest.getTitulo());
        especialidad.setFuncion(especialidadRequest.getFuncion());
        especialidad.setFechgraduacion(sumarUnDiasMas(especialidadRequest.getFechgraduacion()));
        Medico medico = new Medico();
        medico.setIdmedico(especialidadRequest.getIdmedico());
        especialidad.setMedico(medico);
        this.registrarEspecialidad(especialidad);
    }

    @Override
    public void registrarEspecialidad(Especialidad especialidad) {
        especialidadRepository.save(especialidad);
    }

    @Override
    public Especialidad buscarPorId(Integer idespecialidad) {
        Especialidad especialidad = null;
        Optional<Especialidad> optional = especialidadRepository.findById(idespecialidad);
        if(optional.isPresent())
            especialidad = optional.get();
        return especialidad;
    }

    @Override
    public List<Especialidad> listarEspecialidades() {
        return especialidadRepository.findAll();
    }

    @Override
    public void eliminarEspecialidad(Integer idespecialidad) {
        especialidadRepository.deleteById(idespecialidad);
    }

    public static Date sumarUnDiasMas(Date fecha){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }
}
