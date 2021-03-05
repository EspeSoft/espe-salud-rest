package com.espe.salud.dto.evolucion;

import com.espe.salud.dto.catalogo.RepertorioMedicamentoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PrescripcionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private Integer cantidad;

    private String dosis;

    private String presentacion;

    private String indicacion;

    private String idEvolucion;

    private RepertorioMedicamentoDTO medicamento;
}
