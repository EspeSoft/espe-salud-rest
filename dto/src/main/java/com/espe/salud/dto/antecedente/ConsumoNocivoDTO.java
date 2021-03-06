package com.espe.salud.dto.antecedente;

import com.espe.salud.dto.catalogo.TipoConsumoNocivoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class ConsumoNocivoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private LocalDate fechaRegistro;
    private LocalDate fechaTentativaInicio;
    private TipoConsumoNocivoDTO nombreConsumoNocivo;
    private Integer tiempoConsumoMes;
    private String frecuenciaConsumo;
    private Integer cantidadConsumo;
    private Integer tiempoAbstinenciaMes;
    private String observacion;

    @NotNull
    private Long idAntecedentePersonal;

}
