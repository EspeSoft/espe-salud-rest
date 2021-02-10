package com.espe.salud.domain.entities.odontologia;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class DetalleOdontograma {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCDET_ODO_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCDET_ODO_TIPO")
    @Size(max=30, message = "{Size.DetalleOdontograma.tipo}")
    @NotEmpty(message = "{NotEmpty.DetalleOdontograma.tipo}")
    protected String tipo;

    @Column(name = "MZSTCDET_ODO_HISTORIA_ID")
    private Long historiaId;

}
