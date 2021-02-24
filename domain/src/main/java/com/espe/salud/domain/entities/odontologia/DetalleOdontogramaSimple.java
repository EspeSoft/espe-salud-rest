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
@Table(name = "MZSTDETODOGRASIM", schema = "SALUD")
public class DetalleOdontogramaSimple extends DetalleOdontogramaGrafico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "MZSTDETODOGRASIM_CARA")
    @NotEmpty(message = "{NotEmpty.DetalleOdontogramaSimple.cara}")
    private String cara;

    @Column(name = "MZSTDETODOGRASIM_PIEZA")
    private int pieza;
}
