package com.espe.salud.domain.entities.odontologia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class DetalleOdontogramaGrafico extends DetalleOdontograma {

    @Column(name = "MZSTCDET_ODO_GRA_REALIZADO")
    protected boolean realizado;


}