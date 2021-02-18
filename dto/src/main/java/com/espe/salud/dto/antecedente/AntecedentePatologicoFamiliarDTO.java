package com.espe.salud.dto.antecedente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class AntecedentePatologicoFamiliarDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String tipoEnfermedad;
    private String parentezco;
    private String diagnostico;
    private String observacion;

    private Long idAntecedentePersonal;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private AntecedentePersonalDTO antecedentePersonalDTO;
}
