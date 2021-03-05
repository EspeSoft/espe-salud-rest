package com.espe.salud.dto.catalogo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RepertorioMedicamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;
}
