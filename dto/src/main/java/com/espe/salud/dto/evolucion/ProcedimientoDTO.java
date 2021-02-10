package com.espe.salud.dto.evolucion;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProcedimientoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String tipoProcedimiento;
    private Integer numeroActividades;
    private String nota;
    //private Long idResponsable;

}
