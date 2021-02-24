package com.espe.salud.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RiesgoLaboral {
    FISICO,
    QUIMICO,
    MECANICO,
    ERGONOMICO,
    BIOLOGICO,
    PSICOSOCIAL
}
