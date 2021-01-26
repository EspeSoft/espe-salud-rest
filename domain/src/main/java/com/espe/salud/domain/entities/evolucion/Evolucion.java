package com.espe.salud.domain.entities.evolucion;

import com.espe.salud.domain.entities.catalogo.Dispensario;
import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.domain.enums.EstadoNotaEvolucion;
import com.espe.salud.domain.generators.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "MZSTEVO", schema = "SALUD")
public class Evolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evolucion_sequence")
    @GenericGenerator(
            name = "evolucion_sequence",
            strategy = "com.espe.salud.domain.generators.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "EV_"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%07d") })
    @Column(name = "MZSTEVO_CODIGO")
    private String codigo;

    @Column(name = "MZSTEVO_FECHA_INICIO")
    private LocalDateTime fechaInicio;

    @Enumerated(EnumType.STRING)
    @Column(name = "MZSTEVO_ESTADO")
    private EstadoNotaEvolucion estado;

    @Column(name = "MZSTEVO_FECHA_FINALIZACION")
    private LocalDateTime fechaFinalizacion;

    @Column(name = "MZSTEVO_RESPONSABLE_PIDM")
    private Long responsablePidm;

    @Column(name = "MZSTEVO_OBSERVACION")
    private String observacion;

    @Column(name = "MZSTEVO_MOTIVO_CONSULTA")
    private String motivoConsulta;

    @Column(name = "MZSTEVO_MOTIVO_ATENCION")
    private String motivoAtencion;

    @Lob
    @Column(name = "MZSTEVO_NOTA_EVOLUCION")
    private String notaEvolucion;

    @Column(name = "MZSTEVO_ES_ENFERMEDAD_OCUPACIONAL")
    private Boolean esEnfermedadOcupacional;

    @Embedded
    private Referencia referencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_CDIS_EVO", insertable = false, updatable = false)
    private Dispensario dispensario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PAC_EVO", referencedColumnName = "MZSTPAC_CODIGO", insertable = false, updatable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_EVO_EVO", referencedColumnName = "MZSTEVO_CODIGO")
    private Evolucion evolucionPadre;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_nota_enfermeria", referencedColumnName = "id", insertable = false, updatable = false)
//    private NotaEnfermeria notaEnfermeria;

    @CreatedDate
    @Column(name = "MZSTEVO_FECHA_CREACION")
    private LocalDate fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTEVO_FECHA_MODIFICACION")
    private LocalDate fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTEVO_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTEVO_USUARIO_MODIFICACION")
    private String usuarioModificacion;
}
