package com.espe.salud.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ParentescoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;
    private String tipo;
}
