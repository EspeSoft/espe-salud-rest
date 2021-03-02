package com.espe.salud.domain.entities.catalogo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MZSTCTIPDETEXALAB", schema = "SALUD")
public class TipoDetalleExamenLaboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCTIPDETEXALAB_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCTIPDETEXALAB_NOMBRE")
    private String nombre;

    @Column(name = "MZSTCTIPDETEXALAB_UNIDAD")
    private String unidad;

    @Column(name = "FK_TIPEXALAB_DETEXLAB")
    private Long idTipoExamenLaboratorio;

    @ManyToOne
    @JoinColumn(name = "FK_TIPEXALAB_DETEXLAB", insertable = false, updatable = false)
    private TipoExamenLaboratorio tipoExamenLaboratorio;
}
