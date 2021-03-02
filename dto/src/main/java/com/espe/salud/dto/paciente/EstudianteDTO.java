package com.espe.salud.dto.paciente;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class EstudianteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime fechaIngresoEspe;
    private String nivel;
    private String carrera;

    private String escuela;
    private String departamento;
    private String actividadesRelevantes;
    private String parroquiaEstudio;
    private String cantonEstudio;
    private String provinciaEstudio;
    private String direccionLugarEstudio;
}
