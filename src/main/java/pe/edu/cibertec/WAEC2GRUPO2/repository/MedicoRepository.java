package pe.edu.cibertec.WAEC2GRUPO2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.WAEC2GRUPO2.model.bd.Medico;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    List<Medico> findAllByOrderByApemedico();
}
