package com.espe.salud.dto.odontologia;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
public abstract class DetalleOdontogramaGraficoDTO extends DetalleOdontogramaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    protected boolean realizado;


}