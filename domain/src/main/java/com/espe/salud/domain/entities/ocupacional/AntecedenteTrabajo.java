package com.espe.salud.domain.entities.ocupacional;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
public abstract class AntecedenteTrabajo {

    @Column(name = "MZSTANTTRA_EMPRESA")
    private String empresa;

    @Column(name = "MZSTANTTRA_FECHA")
    private LocalDate fecha;

    @Column(name = "MZSTANTTRA_OBSERVACIONES")
    private String observaciones;

    @Column(name = "MZSTANTTRA_RECIBIO_ATENCION")
    private Boolean recibioAtencion;

    @Column(name = "MZSTANTTRA_RIESGO_IMPLICADO")
    private String riesgoImplicado;

    @Column(name = "MZSTANTTRA_SECUELAS")
    private String secuelas;

    @Column(name = "MZSTANTTRA_HORAS_REPOSO")
    private Float horasReposo;
}
