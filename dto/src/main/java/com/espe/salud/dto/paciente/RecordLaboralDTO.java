package com.espe.salud.dto.paciente;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class RecordLaboralDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private LocalDate fechaRegistro;
    private String causa;
    private int edad;
    private LocalDate fechaSalidad;
    private LocalDate fechaReingreso;
    private int diasEntreSalidoIngreso;

}
