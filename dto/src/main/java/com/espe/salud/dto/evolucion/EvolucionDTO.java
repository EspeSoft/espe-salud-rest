package com.espe.salud.dto.evolucion;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class EvolucionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String codigo;
    private LocalDate fechaInicio;
}
