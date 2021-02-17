package com.espe.salud.domain.entities.antecedente;

import com.espe.salud.domain.entities.catalogo.TipoEstudioComplementario;
import com.espe.salud.domain.entities.paciente.Paciente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "MZSTESTCOM", schema = "SALUD")
public class EstudioComplementario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTESTCOM_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTESTCOM_FECHA_ESTUDIO")
    private LocalDate fechaEstudio;

    @Column(name = "MZSTESTCOM_DESCRIPCION_ESTUDIO", columnDefinition = "TEXT")
    private String descripcionEstudio;

    @Column(name = "FK_PAC_ESTCOM")
    private Long idPaciente;

    @Column(name = "FK_TIPESTCOM_ESTCOM")
    private Long idNombreEstudio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_TIPESTCOM_ESTCOM", insertable = false, updatable = false, nullable = false)
    private TipoEstudioComplementario nombreEstudio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PAC_ESTCOM", insertable = false, updatable = false, nullable = false)
    private Paciente paciente;
}
