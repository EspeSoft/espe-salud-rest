package com.espe.salud.domain.entities.odontologia;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.espe.salud.domain.entities.odontologia.DetalleOdontograma;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MZSTDETODOCUA", schema = "SALUD")
public class DetalleOdontogramaCuantitativo extends DetalleOdontograma implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "DETODOCUA_NIVEL")
    @Min(1)
    @Max(4)
    private int nivel;

    @Column(name = "DETODOCUA_PIEZA")
    private int pieza;
}
