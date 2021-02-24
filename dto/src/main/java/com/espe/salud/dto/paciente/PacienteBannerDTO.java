package com.espe.salud.dto.paciente;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PacienteBannerDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String numeroArchivo;
    private Boolean esEstudiante;
    private Boolean esEmpleado;
    private Boolean aceptaTransfucion;
    private String lateralidad;
    private Long idDispensario;
}
