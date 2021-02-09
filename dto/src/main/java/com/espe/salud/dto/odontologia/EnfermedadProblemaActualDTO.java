package com.espe.salud.dto.odontologia;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EnfermedadProblemaActualDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String descripcion;
    private String codigoCie;
    private Long historiaId;

}
