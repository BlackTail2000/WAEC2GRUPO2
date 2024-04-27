package pe.edu.cibertec.WAEC2GRUPO2.service;

import pe.edu.cibertec.WAEC2GRUPO2.model.bd.Medico;

import java.util.List;

public interface IMedicoService {

    List<Medico> listarMedicosOrdenadosPorApellido();
}
