package com.espe.salud.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @NotNull
    private Long pidm;

    @NotEmpty
    private String nombres;

    @NotEmpty
    private String cedula;

    private Boolean activo;

    private Long idAreaSalud;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private AreaSaludDTO areaSalud;

    // TODO Agregar dispensario DTO

    @NotNull
    private Long idDispensario;
}
