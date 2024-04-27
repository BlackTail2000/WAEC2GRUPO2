package pe.edu.cibertec.WAEC2GRUPO2.service;
import pe.edu.cibertec.WAEC2GRUPO2.model.bd.Usuario;

public interface IUsuarioService {
    Usuario findUserByNomUsuario(String nomusuario);
    Usuario guardarNuevoUsuario(Usuario usuario);
}
