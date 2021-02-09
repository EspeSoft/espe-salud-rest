package com.espe.salud.dto.paciente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PacienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String numeroArchivo;
    private Boolean activo;
    private Boolean esEstudiante;
    private Boolean esEmpleado;
    private Boolean accesoBanner;

}
