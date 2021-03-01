package com.espe.salud.common.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoReporte {
    CERTIFICADO_MEDICO_GENERAL("CERTIFICADO_MEDICO_GENERAL");
    private final String key;
}
