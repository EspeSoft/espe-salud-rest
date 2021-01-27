package com.espe.salud.dto.paciente;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
public class PacienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String numeroArchivo;
    private boolean activo;
    private Boolean esEstudiante;
    private Boolean esEmpleado;
    private Boolean accesoBanner;

}
