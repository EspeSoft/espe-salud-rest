package com.espe.salud.dto.odontologia;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Getter
@Setter

public class DetalleOdontogramaCuantitativoDTO extends DetalleOdontogramaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int nivel;

    private int pieza;

}
