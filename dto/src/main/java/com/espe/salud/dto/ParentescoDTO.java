package com.espe.salud.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ParentescoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long codigo;
    private String nombre;
    private String tipo;
}
