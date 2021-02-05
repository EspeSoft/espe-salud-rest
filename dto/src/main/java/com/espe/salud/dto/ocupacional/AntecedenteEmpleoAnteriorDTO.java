package com.espe.salud.dto.ocupacional;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AntecedenteEmpleoAnteriorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String empresa;
    private String puestoTrabajo;
    private String actividadDesempeñaba;
    private Integer tiempoTrabajoMes;
    private Boolean recibiaVigilanciaSalud;
    private String observacion;
}
