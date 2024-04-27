package pe.edu.cibertec.WAEC2GRUPO2.service;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.WAEC2GRUPO2.model.bd.Usuario;

import pe.edu.cibertec.WAEC2GRUPO2.repository.UsuarioRepository;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService {

    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder=
            new BCryptPasswordEncoder();

        @Override
        public Usuario findUserByNomUsuario(String nomusuario){
            return usuarioRepository.findByNomusuario(nomusuario);

        }

}
