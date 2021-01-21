package com.espe.salud.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoNotaEnfermeria {
    INICIADO,
    ATENDIENDO,
    POSTCONSULTA,
    FINALIZADO;
}
