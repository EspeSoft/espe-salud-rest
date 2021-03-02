package com.espe.salud.dto.catalogo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class TipoActividadEnfermeriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    //    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String nombre;
    private List<DescripcionActividadEnfermeriaDTO> descripcionActividadEnfermerias;
}
