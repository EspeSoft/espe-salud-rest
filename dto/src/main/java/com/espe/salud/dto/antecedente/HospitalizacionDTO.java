package com.espe.salud.dto.antecedente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class HospitalizacionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private LocalDate fechaIngreso;
    private String casaSalud;
    private String diagnosticoIngreso;
    private String evolucionProcedimientoComplicaciones;
    private String diagnosticoEgreso;
    private String tiempoEstadia;
    private LocalDate fechaAlta;
    private Integer diasIncapacidad;
    private String indicacionesAlta;
    private String tipoEgreso;
    private String medicoTratante;
    private String especialidadMedico;

    @NotNull
    private Long idPaciente;
}
