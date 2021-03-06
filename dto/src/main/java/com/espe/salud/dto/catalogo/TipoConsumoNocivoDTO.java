package com.espe.salud.dto.catalogo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class TipoConsumoNocivoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty
    private String nombre;
}
