package com.espe.salud.domain.entities.evolucion;

import com.espe.salud.domain.entities.catalogo.RepertorioMedicamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MZSTPRES", schema = "SALUD")
public class Prescripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTPRES_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTPRES_CANTIDAD")
    private Integer cantidad;

    @Column(name = "MZSTPRES_DOSIS")
    private String dosis;

    @Column(name = "MZSTPRES_PRESENTACION")
    private String presentacion;

    @Column(name = "MZSTPRES_INIDICACION")
    private String indicacion;

    @Column(name = "FK_EVO_PRES")
    private String idEvolucion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_EVO_PRES", insertable=false , updatable = false, nullable = false)
    private Evolucion evolucion;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_REPMED_PRES")
    private RepertorioMedicamento medicamento;

}
