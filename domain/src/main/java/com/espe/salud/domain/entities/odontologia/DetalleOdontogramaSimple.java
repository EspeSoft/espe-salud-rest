package com.espe.salud.domain.entities.odontologia;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MZSTCDET_ODO_SIM", schema = "SALUD")
public class DetalleOdontogramaSimple extends DetalleOdontogramaGrafico implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Column(name = "MZSTCDET_ODO_SIM_CARA")
    @NotEmpty(message = "{NotEmpty.DetalleOdontogramaSimple.cara}")
    private String cara;

    @Column(name = "MZSTCDET_ODO_SIM_PIEZA")
    private int pieza;
}