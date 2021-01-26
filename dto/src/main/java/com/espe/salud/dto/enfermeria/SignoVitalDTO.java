package com.espe.salud.dto.enfermeria;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SignoVitalDTO {
    private String presionArterial;
    private Double frecuenciaCardiaca;
    private Double frecuenciaRespiratoria;
    private Double temperatura;
    private Double saturacionOxigeno;
    private LocalDate fechaUltimaMenstruacion;
}
