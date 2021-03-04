package com.espe.salud.domain.entities.evolucion;

import com.espe.salud.domain.entities.catalogo.RepertorioMedicamento;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MZSTPRES", schema = "SALUD")
public class Prescripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTPRES_CODIGO")
    private Long codigo;

    @Column(name = "MZSTPRES_CANTIDAD")
    @NotNull
    private Integer cantidad;

    @Column(name = "MZSTPRES_DOSIS")
    private String dosis;

    @Column(name = "MZSTPRES_PRESENTACION")
    private String presentación;

    @Column(name = "MZSTPRES_INIDICACION")
    private String indicacion;

    @Column(name = "FK_EVO_PRES")
    private String idEvolucion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_EVO_PRES", insertable = false, updatable = false, nullable = false)
    private Evolucion evolucion;

    @Column(name = "FK_REPMED_PRES")
    private Long idMedicamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_REPMED_PRES", insertable = false, updatable = false, nullable = false)
    private RepertorioMedicamento medicamento;

}
