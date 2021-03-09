package com.espe.salud.dto.antecedente;

import com.espe.salud.dto.catalogo.EnfermedadCIE10DTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class AntecedenteQuirurgicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String idDiagnosticoPreQuirurgico;
    private EnfermedadCIE10DTO diagnosticoPreQuirurgico;
    private String procedimientoQuirurgico;
    private LocalDate fechaProcedimiento;
    private String secuelas;

    @NotNull
    private Long idAntecedentePersonal;
}
