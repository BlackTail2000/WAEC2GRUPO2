package pe.edu.cibertec.WAEC2GRUPO2.repository;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.WAEC2GRUPO2.model.bd.Usuario;

@Repository
public interface UsuarioRepository extends
        JpaRepository<Usuario, Integer> {
    Usuario findByNomusuario(String nomusuario);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Usuario SET password=:password WHERE idusuario=:idusuario")
    void actualizarPassowrd(@Param("password") String password, @Param("idusuario") Integer idusuario);
}
