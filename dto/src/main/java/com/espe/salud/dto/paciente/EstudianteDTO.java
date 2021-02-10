package com.espe.salud.dto.paciente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class EstudianteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private LocalDate fechaIngresoEspe;
    private String departamento;
    private String escuela;
    private String carrera;
    private String actividadesRelevantes;
    private String parroquia;
    private String direccionLugarEstudio;
    private Long idCantonEstudio;
    private Long idProvinciaEstudio;
    private Long idSede;

}
