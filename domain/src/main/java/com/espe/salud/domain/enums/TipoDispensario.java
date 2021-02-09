package com.espe.salud.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoDispensario {
    BELISARIO ("belisario.jpg"),
    LATACUNGA ("latacunga.jpg"),
    SANGOLQUI ("sangolqui.jpg"),
    STODOMINGO("stodomingo.jpg");
    private final String key;
}
