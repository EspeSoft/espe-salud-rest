package com.espe.salud.dto.catalogo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DispensarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String institucionSistema;
    private String unidadOperativa;
    private String uniCodigo;
    private String nombreImagen;
    private String campus;
    private String canton;
    private String provincia;
}