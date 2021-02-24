package com.espe.salud.dto.odontologia;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class HistoriaClinicaOdontologicaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private LocalDateTime fechaApertura;
    private LocalDateTime fechaControl;
    private String profesional;
    private String codigoProfesional;
    private Long pacienteId;
    
}
