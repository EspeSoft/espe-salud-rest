package com.espe.salud.dto.antecedente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
public class AntecedenteGinecologicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate fecha;
    private Integer edadMenarquia;
    private String cicloMenstruacion;
    private LocalDate fechaUltimaMenstruacion;
    private Integer gestas;
    private Integer numeroPartosVaginales;
    private Integer numeroCesareas;
    private Integer numeroAbortos;
    private Integer hijosMuertos;
    private Integer hijosVivos;
    private Long idAntecedentePersonal;
}
