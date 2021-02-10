package com.espe.salud.dto.antecedente;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class AntecedentePatologicoPersonalDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String tipoEnfermedadPersonal;
    private LocalDate fechaDiagnostico;
    private String tomaMedicacion;
    private String diagnostico;
    private String antecedentePersonal;
}
