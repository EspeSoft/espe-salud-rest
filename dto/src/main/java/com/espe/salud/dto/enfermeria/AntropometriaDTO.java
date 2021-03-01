package com.espe.salud.dto.enfermeria;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AntropometriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private Double peso;
    private Double talla;
    private Double indiceMasaCorporal;
    private Double perimetroAbdominal;
}
