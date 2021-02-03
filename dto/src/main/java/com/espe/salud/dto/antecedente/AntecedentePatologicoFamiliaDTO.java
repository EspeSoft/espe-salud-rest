package com.espe.salud.dto.antecedente;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class AntecedentePatologicoFamiliaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String tipoEnfermedad;
    private String parentezco;
    private String diagnostico;
    private String observacion;
}
