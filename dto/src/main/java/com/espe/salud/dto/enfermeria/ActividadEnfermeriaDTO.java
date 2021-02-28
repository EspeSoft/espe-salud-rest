package com.espe.salud.dto.enfermeria;

import com.espe.salud.dto.catalogo.TipoActividadEnfermeriaDTO;
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
    @NotNull
    private Long idTipoActividadEnfermeria;
    @NotNull
    private Long idUsuario;
    private String descripcion;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private UsuarioDTO usuario;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private TipoActividadEnfermeriaDTO tipoActividadEnfermeria;


}
