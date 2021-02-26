package com.espe.salud.dto.antecedente;

import com.espe.salud.dto.catalogo.EnfermedadCIE10DTO;
import com.espe.salud.dto.catalogo.TipoEnfermedadPersonalDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class AntecedentePatologicoPersonalDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private LocalDate fechaDiagnostico;
    private String frecuenciaMedicacion;
    private String observaciones;
    private String idDiagnostico;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private EnfermedadCIE10DTO diagnostico;

    private Long idTipoEnfermedadPersonal;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private TipoEnfermedadPersonalDTO tipoEnfermedadPersonal;

    private Long idAntecedentePersonal;
}
