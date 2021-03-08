package com.espe.salud.domain.entities.ocupacional;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class DetalleAntecedente extends AntecedenteTrabajo {

    @Column(name = "MZSTDETANT_LUGAR_ATENCION")
    private String lugarAtencion;

    @Column(name = "MZSTDETANT_NATURALEZA")
    private String naturaleza;

    @Column(name = "MZSTDETANT_PARTE_CUERPO_AFECTADA")
    private String parteCuerpoAfectada;
}
