package com.espe.salud.dto.catalogo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class EnfermedadCIE10DTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String codigo;
    private String nombre;

    @NotEmpty
    private String idGrupoEnfermedadCIE10;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private GrupoEnfermedadDTO grupoEnfermedadCIE10;
}
