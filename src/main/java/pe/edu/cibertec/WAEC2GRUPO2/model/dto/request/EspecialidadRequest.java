package pe.edu.cibertec.WAEC2GRUPO2.model.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class EspecialidadRequest {
    private Integer idespecialidad;
    private String titulo;
    private String funcion;
    private Date fechgraduacion;
    private Integer idmedico;
}
