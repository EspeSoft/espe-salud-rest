package com.espe.salud.dto.evolucion;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class EvolucionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = AccessMode.READ_ONLY)
    private String id;

    private LocalDateTime fechaInicio;
}
