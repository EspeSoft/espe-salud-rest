package com.espe.salud.dto.ocupacional;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public abstract class AntecedenteTrabajoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String empresa;
    private LocalDate fecha;
    private String lugarAtencion;
    private String observaciones;
    private Boolean recibioAtencion;
    private String riesgoImplicado;
    private String secuelas;
    private Float horasReposo;
}
