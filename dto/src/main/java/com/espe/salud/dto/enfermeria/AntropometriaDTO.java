package com.espe.salud.dto.enfermeria;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AntropometriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Double peso;
    private Double talla;
    private Double indiceMasaCorporal;
    private Double perimetroAbdominal;
}
