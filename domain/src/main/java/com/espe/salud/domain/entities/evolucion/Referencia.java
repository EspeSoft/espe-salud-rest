package com.espe.salud.domain.entities.evolucion;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class Referencia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "MZSTEVO_TIPO_REFERENCIA")
    private String tipoReferencia;

    @Column(name = "MZSTEVO_TIPO_INTER_CONSULTA")
    private String tipoInterConsulta;
}
