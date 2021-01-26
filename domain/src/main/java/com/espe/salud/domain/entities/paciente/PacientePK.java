package com.espe.salud.domain.entities.paciente;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class PacientePK implements Serializable {
    private static final long seriaVersionUID = 1L;

    @Column(name = "MZSTPAC_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTPAC_NUMERO_ARCHIVO")
    private String numeroArchivo;
}
