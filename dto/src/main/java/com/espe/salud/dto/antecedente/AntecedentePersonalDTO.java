package com.espe.salud.dto.antecedente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class AntecedentePersonalDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String orientacionSexual;
    private String identidadGenero;
    private String poseeAlergia;
    private String descripcionAlergia;
    private String frecuenciaAlimentacion;
    private String predominioAlimentario;
    private String horaSuenio;
    private String horaDespertar;
    private String observacionAlimentacion;
    private String observacionHabitoSuenio;

    @NotNull
    private Long idPaciente;
}
