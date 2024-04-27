package pe.edu.cibertec.WAEC2GRUPO2.service;

import pe.edu.cibertec.WAEC2GRUPO2.model.bd.Especialidad;

import java.util.List;

public interface IEspecialidadService {

    void registrarEspecialidad(Especialidad especialidad);
    Especialidad buscarPorId(Integer idespecialidad);
    List<Especialidad> listarEspecialidades();
    void eliminarEspecialidad(Integer idespecialidad);
}
