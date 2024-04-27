package pe.edu.cibertec.WAEC2GRUPO2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.WAEC2GRUPO2.model.bd.Medico;
import pe.edu.cibertec.WAEC2GRUPO2.repository.MedicoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicoService implements IMedicoService {
    private MedicoRepository medicoRepository;
    @Override
    public List<Medico> listarMedicosOrdenadosPorApellido() {
        return medicoRepository.findAllByOrderByApemedico();
    }
}
