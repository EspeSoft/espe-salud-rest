package com.espe.salud.dto.odontologia;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class DetalleOdontogramaSimpleDTO extends DetalleOdontogramaGraficoDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String cara;

    private int pieza;
}
