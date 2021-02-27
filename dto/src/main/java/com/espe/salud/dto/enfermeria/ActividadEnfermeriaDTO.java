package com.espe.salud.dto.enfermeria;

import com.espe.salud.dto.usuario.UsuarioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
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
    @NotNull
    private Long idUsuario;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private UsuarioDTO usuarioDTO;

}
