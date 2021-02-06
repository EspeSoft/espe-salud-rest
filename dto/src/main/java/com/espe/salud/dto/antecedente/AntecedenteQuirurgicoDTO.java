package com.espe.salud.dto.antecedente;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class AntecedenteQuirurgicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String diagnosticoPreQuirurgico;
    private String procedimientoQuirurgico;
    private LocalDate fechaProcedimiento;
    private String secuelas;
}
