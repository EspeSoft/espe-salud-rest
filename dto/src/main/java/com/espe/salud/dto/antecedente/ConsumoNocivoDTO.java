package com.espe.salud.dto.antecedente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ConsumoNocivoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String nombreConsumoNocivo;
    private String consume;
    private Integer tiempoConsumoMes;
    private String frecuenciaConsumo;
    private Integer cantidadConsumo;
    private String exConsumidor;
    private Integer tiempoAbstinenciaMes;
    private String observacion;

    private Long idAntecedentePersonal;

}
