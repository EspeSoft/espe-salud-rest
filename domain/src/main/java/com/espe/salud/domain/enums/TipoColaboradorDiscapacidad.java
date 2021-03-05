package com.espe.salud.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoColaboradorDiscapacidad {
    COLABORADOR_DISCAPACIDAD("COLABORADOR CON DISCAPACIDAD"),
    COLABORADOR_SUSTITUTO("COLABORADOR SUSTITUTO");
    private final String key;
}
