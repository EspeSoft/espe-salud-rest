package com.espe.salud.domain.entities.odontologia;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class DetalleOdontograma {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "MZSTDETODO_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTDETODO_TIPO")
    @Size(max=30, message = "{Size.DetalleOdontograma.tipo}")
    @NotEmpty(message = "{NotEmpty.DetalleOdontograma.tipo}")
    protected String tipo;


    @Column(name = "FK_HISCLIODO_DETODO")
    private Long historiaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_HISCLIODO_DETODO", insertable = false, updatable = false, nullable = false)
    private HistoriaClinicaOdontologica historia;

}