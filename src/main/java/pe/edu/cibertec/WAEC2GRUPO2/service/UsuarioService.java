package pe.edu.cibertec.WAEC2GRUPO2.service;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.WAEC2GRUPO2.model.bd.Rol;
import pe.edu.cibertec.WAEC2GRUPO2.model.bd.Usuario;

import pe.edu.cibertec.WAEC2GRUPO2.repository.RolRepository;
import pe.edu.cibertec.WAEC2GRUPO2.repository.UsuarioRepository;

import java.util.Arrays;
import java.util.HashSet;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder=
            new BCryptPasswordEncoder();

        @Override
        public Usuario findUserByNomUsuario(String nomusuario){
            return usuarioRepository.findByNomusuario(nomusuario);

        }

    @Override
    public Usuario guardarNuevoUsuario(Usuario usuario) {
        usuario.setActivo(true);
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        Rol usuarioRol = rolRepository.findByNomRol("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        return usuarioRepository.save(usuario);
    }

}
