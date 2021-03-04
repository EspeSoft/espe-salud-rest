package com.espe.salud.dto.antecedente;

import com.espe.salud.dto.catalogo.EnfermedadCIE10DTO;
import com.espe.salud.dto.catalogo.TipoEnfermedadDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Getter
@Setter
public class AntecedentePatologicoFamiliarDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String parentesco;

    private String observacion;

    @NotNull
    private String idDiagnostico;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private EnfermedadCIE10DTO diagnostico;

    @NotNull
    private Long idTipoEnfermedadFamiliar;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private TipoEnfermedadDTO tipoEnfermedadFamiliar;

    @NotNull
    private Long idAntecedentePersonal;
}
