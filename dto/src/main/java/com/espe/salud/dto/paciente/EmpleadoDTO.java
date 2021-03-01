package com.espe.salud.dto.paciente;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class EmpleadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String campus;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime fechaIngresoLaboral;
    private String seccion;
    private String departamento;
    private String cantonTrabajo;
    private String provinciaTrabajo;
    private String direccionLaboral;
    private String areaTrabajo;
    private String cargoTrabajoActual;

    private String parroquiaTrabajo;
    private String ciuo;
    private String actividadesRelevantes;
    private String tipoJornadaLaboral;
    private Integer horasTrabajoDia;
    private Integer horasTrabajoSemana;
    private Integer horasTrabajoMes;
    private String cumpleMisionServicio;
    private String observacionHorario;
    private String situacionAdministrativa;
}
