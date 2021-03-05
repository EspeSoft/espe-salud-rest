package com.espe.salud.dto.evolucion;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class DiagnosticoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotNull
    private String codigoCIE;
    private String prevencion;
    private String morbilidad;
    private String condicionDiagnostico;
}
