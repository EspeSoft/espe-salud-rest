package com.espe.salud.dto.odontologia;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class HistoriaClinicaOdontologicaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDate fechaApertura;
    private LocalDate fechaControl;
    private String profesional;
    private String codigoProfesional;
    private Long pacienteId;
    
}
