package com.espe.salud.dto.antecedente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class AntecedenteQuirurgicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String diagnosticoPreQuirurgico;
    private String procedimientoQuirurgico;
    private LocalDate fechaProcedimiento;
    private String secuelas;

    private Long idAntecedentePersonal;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private AntecedentePersonalDTO antecedentePersonalDTO;
}
