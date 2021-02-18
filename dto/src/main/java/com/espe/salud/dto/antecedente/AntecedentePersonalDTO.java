package com.espe.salud.dto.antecedente;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AntecedentePersonalDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String orientacionSexual;
    private String identidadGenero;
    private String poseeAlergia;
    private String descripcionAlergia;
    private Boolean tomaMedicacion;
    private Boolean realizaActividadFisica;
    private String frecuenciaAlimentacion;
    private String predominioAlimentario;
    private String horaSuenio;
    private String horaDespertar;
    private String observacionAlimentacion;
    private String observacionHabitoSuenio;
}
