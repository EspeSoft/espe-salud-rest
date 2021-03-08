package com.espe.salud.dto.antecedente;

import com.espe.salud.dto.catalogo.EnfermedadCIE10DTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class DiscapacidadDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String tipoColaborador;
    private String tipoDiscapacidad;
    private String porcentajeDiscapacidad;
    private String gradoDiscapacidad;

    private String idDiagnosticoRelacionDiscapacidad;
    private EnfermedadCIE10DTO diagnosticoRelacionDiscapacidad;

    @NotNull
    private Long idAntecedentePersonal;
}