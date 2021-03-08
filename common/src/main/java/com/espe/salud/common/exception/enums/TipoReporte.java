package com.espe.salud.common.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoReporte {
    CERTIFICADO_MEDICO_GENERAL("CERTIFICADO_MEDICO_GENERAL"),
    RECETA_MEDICO("RECETA_MEDICO");
    private final String key;

}
