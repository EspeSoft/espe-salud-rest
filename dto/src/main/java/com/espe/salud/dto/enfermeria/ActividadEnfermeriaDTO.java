package com.espe.salud.dto.enfermeria;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class ActividadEnfermeriaDTO implements Serializable {
    private final static long serialVersion = 1L;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private LocalDateTime fecha;
    private Long idTipoActividadEnfermeria;
    private Long idUsuario;

}
