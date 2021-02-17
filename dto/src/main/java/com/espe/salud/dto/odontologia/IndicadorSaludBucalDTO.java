package com.espe.salud.dto.odontologia;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class IndicadorSaludBucalDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private Integer nivelEnfermedadPeriodontal;
    private Integer nivelMaloclusion;
    private Integer nivelFluorosis;
    private Long historiaId;

}
