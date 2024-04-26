package pe.edu.cibertec.WAEC2GRUPO2.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idespecialidad;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "funcion")
    private String funcion;
    @Column(name = "fechgraduacion")
    @Temporal(TemporalType.DATE)
    private Date fechgraduacion;
    @ManyToOne
    @JoinColumn(name = "idmedico")
    private Medico medico;
}
