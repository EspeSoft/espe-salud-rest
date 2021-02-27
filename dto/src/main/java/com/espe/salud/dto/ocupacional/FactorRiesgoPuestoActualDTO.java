package com.espe.salud.dto.ocupacional;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
public class FactorRiesgoPuestoActualDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String puestoTrabajo;
    private String actividadPuesto;
    private String medidaPreventiva;
    private String maquinaria;
    private Long idAntecedenteLaboral;
}
