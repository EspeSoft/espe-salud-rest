package com.espe.salud.dto.antecedente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
public class AntecedentePersonalDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String orientacionSexual;
    private String identidadGenero;
    private String poseeAlergia;
    private String descripcionAlergia;
    private Boolean tomaMedicacion;
    private Boolean realizaActividadFisica;
    private String frecuenciaAlimentacion;
    private String predominioAlimentario;
    private LocalTime horaSuenio;
    private LocalTime horaDespertar;
    private LocalTime totalHorasSuenio;
    private String observacionAlimentacion;
    private String observacionHabitoSuenio;
}
