package com.espe.salud.dto.enfermeria;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class NotaEnfermeriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime fechaInicio;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime fechaFin;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String estado;

    private String preConsulta;

    private String postConsulta;

    private SignoVitalDTO signoVital;

    private AntropometriaDTO antropometria;
}
