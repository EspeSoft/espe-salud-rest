package com.espe.salud.dto.antecedente;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter

public class AntecedenteGinecologicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Integer edadMenarquia;
    private String cicloMenstruacion;
    private LocalDate fechaUltimaMenstruacion;
    private Integer gestas;
    private Integer numeroPartosVaginales;
    private Integer numeroCesareas;
    private Integer numeroAbortos;
}
