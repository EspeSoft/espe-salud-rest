package com.espe.salud.dto.antecedente;

import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Getter
@Setter
public class DiscapacidadDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Boolean colaboradorDiscapacidad;
    private Boolean esColaboradorSustituto;
    private String diagnosticoRelacionDiscapacidad;
    private String tipoDiscapacidad;
    private String porcentajeDiscapacidad;
    private String gradoDiscapacidad;
}