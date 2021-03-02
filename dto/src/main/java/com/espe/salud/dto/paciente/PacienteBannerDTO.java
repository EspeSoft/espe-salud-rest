package com.espe.salud.dto.paciente;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class PacienteBannerDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String numeroArchivo;
    private Boolean esEstudiante;
    private Boolean esEmpleado;
    private Boolean aceptaTransfucion;
    private String lateralidad;
    private Long idDispensario;
    private String vinculadoEspe;
    private String seguroSalud;
    private String asociacionAfiliada;
}
