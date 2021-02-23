package com.espe.salud.dto.ocupacional;

import com.espe.salud.dto.paciente.PacienteDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AntecedenteLaboralDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private PacienteDTO pacienteDTO;
}