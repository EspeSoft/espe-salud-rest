package com.espe.salud.dto.antecedente;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;


@Getter
@Setter

public class AntecedenteGinecologicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private Integer edadMenarquia;
    private String cicloMenstruacion;
    private LocalDate fechaUltimaMenstruacion;
    private Integer gestas;
    private Integer numeroPartosVaginales;
    private Integer numeroCesareas;
    private Integer numeroAbortos;
}
