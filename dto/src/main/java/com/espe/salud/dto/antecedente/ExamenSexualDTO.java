package com.espe.salud.dto.antecedente;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter

public class ExamenSexualDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private LocalDate fecha;
    private String nombreExamen;
    private Boolean realizado;
    private Integer tiempoAnios;
    private String resuldato;
}
