package com.espe.salud.dto.evolucion;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class ReposoDTO implements Serializable {
    private static final long serialVersion = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private String condicionPaciente;

    private String recomendacion;
}
