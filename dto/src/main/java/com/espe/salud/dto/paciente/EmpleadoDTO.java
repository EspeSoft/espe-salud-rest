package com.espe.salud.dto.paciente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
public class EmpleadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private LocalDate fechaIngresoLaboral;
    private String unidadDepartamento;
    private String observacionHorario;
    private String parroquia;
    private String direccionLaboral;
    private String areaTrabajo;
    private String cargoTrabajoActual;
    private String actividadeRelevante;
    private String tipoJornadaLaboral;
    private Integer horasTrabajoDia;
    private Integer horasTrabajoSemana;
    private Integer horasTrabajoMes;
    private String cumpleMisionServicio;
    private String situacionAdministrativa;
    private Long idCantonTrabajo;
    private Long idProvinciaTrabajo;

}
