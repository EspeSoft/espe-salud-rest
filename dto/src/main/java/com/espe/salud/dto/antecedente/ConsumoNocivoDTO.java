package com.espe.salud.dto.antecedente;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ConsumoNocivoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombreConsumoNocivo;
    private String consume;
    private Integer tiempoConsumoMes;
    private String frecuenciaConsumo;
    private Integer cantidadConsumo;
    private String exConsumidor;
    private Integer tiempoAbstinenciaMes;
    private String observacion;
}
