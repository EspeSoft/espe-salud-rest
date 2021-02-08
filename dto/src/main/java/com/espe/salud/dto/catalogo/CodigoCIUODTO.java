package com.espe.salud.dto.catalogo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CodigoCIUODTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String codigo;
    private String descripcion;
    private String nivel;

}
