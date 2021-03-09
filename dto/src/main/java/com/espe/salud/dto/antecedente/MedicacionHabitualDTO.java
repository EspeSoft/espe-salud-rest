package com.espe.salud.dto.antecedente;

import com.espe.salud.dto.catalogo.FrecuenciaMedicacionHabitualDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class MedicacionHabitualDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String descripcionMedicamento;
    private Long idFrecuencia;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private FrecuenciaMedicacionHabitualDTO frecuencia;
    private Integer cantidad;
    private String observacion;

    @NotNull
    private Long idAntecedentePersonal;
}
