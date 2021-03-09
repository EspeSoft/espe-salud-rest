package com.espe.salud.domain.entities.odontologia;

import com.espe.salud.domain.entities.paciente.Paciente;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "MZSTEXASISEST", schema = "SALUD")
public class ExamenSistemaEstomatognatico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTEXASISEST_CODIGO")
    private Long codigo;

    @Column(name = "MZSTEXASISEST_UNIDAD_ESTOMATOGNATICA")
    @NotEmpty
    private String unidadEstomatognatica;

    @Column(name = "MZSTEXASISEST_CODIGO_CIE_ASOCIADO")
    @Size(max = 12)
    @NotEmpty
    private String codigoCIEAsociado;

    @Column(name = "FK_HISCLIODO_EXASISEST")
    private Long idHistoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_HISCLIODO_EXASISEST", insertable = false, updatable = false)
    private HistoriaClinicaOdontologica historia;

}
