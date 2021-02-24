package com.espe.salud.dto.ocupacional;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public abstract class DetalleTrabajoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String empresa;
    private String puestoTrabajo;
    private String actividad;
    private Float meses;
    private Boolean usabanSeguridad;
    private Boolean vigilanciaSalud;
    private String observacion;
}
