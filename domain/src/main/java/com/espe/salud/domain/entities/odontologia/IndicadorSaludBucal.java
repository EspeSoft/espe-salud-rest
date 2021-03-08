package com.espe.salud.domain.entities.odontologia;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "MZSTINDSALBUC", schema = "SALUD")
public class IndicadorSaludBucal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="MZSTINDSALBUC_CODIGO")
    private Long codigo;

    @Column(name="MZSTINDSALBUC_NIVEL_ENFERMEDAD_PERIODONTAL")
    @Min(1) @Max(3)
    private Integer nivelEnfermedadPeriodontal;

    @Column(name="MZSTINDSALBUC_NIVEL_MALOCLUSION")
    @Min(1) @Max(3)
    private Integer nivelMaloclusion;

    @Column(name="MZSTINDSALBUC_NIVEL_FLUOROSIS")
    @Min(1) @Max(3)
    private Integer nivelFluorosis;


    @Column(name = "FK_HISCLIODO_INDSALBUC")
    private Long historiaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_HISCLIODO_INDSALBUC", insertable = false, updatable = false, nullable = false)
    private HistoriaClinicaOdontologica historia;

}
