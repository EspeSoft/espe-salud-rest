package com.espe.salud.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoSubdivision {
    PROVINCIA("province"),
    CANTON("canton");
    private final String key;
}
