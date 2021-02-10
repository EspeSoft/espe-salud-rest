package com.espe.salud.dto.odontologia;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public abstract class DetalleOdontogramaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    protected String tipo;

    private Long historiaId;

}
