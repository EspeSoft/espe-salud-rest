package com.espe.salud.dto.antecedente;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ActividadFisicaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombreActividad;
    private String frecuencia;
    private Integer horas;
    private String observacion;
}
