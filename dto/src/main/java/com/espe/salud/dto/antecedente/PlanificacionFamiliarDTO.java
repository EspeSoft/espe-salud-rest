package com.espe.salud.dto.antecedente;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
public class PlanificacionFamiliarDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private LocalDate fecha;
    private String vidaSexualActiva;
    private Boolean metodoPlanificacion;
    private Integer edadInicioPlanificacionFamiliar;
    private String frecuenciaPlanificacionFamiliar;
    private String tipoPlanificacionFamiliar;
    private Integer hijosVivos;
    private Integer hijosMuertos;
    private String observacion;
}
