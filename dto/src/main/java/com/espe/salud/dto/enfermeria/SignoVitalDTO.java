package com.espe.salud.dto.enfermeria;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class SignoVitalDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String presionArterial;
    private Double frecuenciaCardiaca;
    private Double frecuenciaRespiratoria;
    private Double temperatura;
    private Double saturacionOxigeno;
    private LocalDate fechaUltimaMenstruacion;
}
