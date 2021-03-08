package com.espe.salud.dto.antecedente;

import com.espe.salud.dto.catalogo.TipoPlanificacionFamiliarDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class PlanificacionFamiliarDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private LocalDate fecha;
    private String vidaSexualActiva;
    private Boolean metodoPlanificacion;
    private String frecuenciaPlanificacionFamiliar;
    private Integer edadInicioPlanificacionFamiliar;
    private Long idTipoPlanificacionFamiliar;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private TipoPlanificacionFamiliarDTO tipoPlanificacionFamiliar;
    private Integer hijosVivos;
    private Integer hijosMuertos;
    private String observacion;

    @NotNull
    private Long idAntecedentePersonal;
}
