package com.espe.salud.domain.entities.enfermeria;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Antropometria {

    @Column(name = "MZSTNOTENF_PESO")
    private Double peso;

    @Column(name = "MZSTNOTENF_TALLA")
    private Double talla;

    @Column(name = "MZSTNOTENF_INDICE_MASA_CORPORAL")
    private Double indiceMasaCorporal;

    @Column(name = "MZSTNOTENF_PERIMETRO_ABDOMINAL")
    private Double perimetroAbdominal;
}
