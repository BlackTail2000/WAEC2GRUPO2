package pe.edu.cibertec.WAEC2GRUPO2.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmedico;
    @Column(name = "nommedico")
    private String nommedico;
    @Column(name = "apemedico")
    private String apemedico;
    @Column(name = "fechnacmedico")
    @Temporal(TemporalType.DATE)
    private Date fechnacmedico;
}
