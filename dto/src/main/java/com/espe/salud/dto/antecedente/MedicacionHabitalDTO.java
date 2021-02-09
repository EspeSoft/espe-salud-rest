package com.espe.salud.dto.antecedente;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MedicacionHabitalDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String descripcionMedicamento;
    private String frecuencia;
    private Integer cantidad;
    private String observacion;
    private String antecedentePersonal;
}
