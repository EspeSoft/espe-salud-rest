package com.espe.salud.dto.usuario;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AreaSaludDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nombre;
}
