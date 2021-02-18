package com.espe.salud.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SexoTipoPlanificacionFamiliar {
    MUJER("MUJER"),
    HOMBRE("HOMBRE"),
    AMBOS("AMBOS");
    private final String key;
}
