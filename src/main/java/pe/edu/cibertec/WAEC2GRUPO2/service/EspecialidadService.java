package pe.edu.cibertec.WAEC2GRUPO2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.WAEC2GRUPO2.model.bd.Especialidad;
import pe.edu.cibertec.WAEC2GRUPO2.repository.EspecialidadRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EspecialidadService implements IEspecialidadService {
    private EspecialidadRepository especialidadRepository;

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
}
