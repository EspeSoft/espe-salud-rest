package com.espe.salud.dto.antecedente;

import com.espe.salud.dto.catalogo.TipoEstudioComplementarioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class EstudioComplementarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private LocalDate fechaEstudio;
    private String descripcionEstudio;
    private TipoEstudioComplementarioDTO nombreEstudio;
    private Long idPaciente;
}
