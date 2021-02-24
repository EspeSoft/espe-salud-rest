package com.espe.salud.dto.ocupacional;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public abstract class DetalleAntecedenteDTO extends AntecedenteTrabajoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String lugarAtencion;
    private String naturaleza;
    private String parteCuerpoAfectada;
}
