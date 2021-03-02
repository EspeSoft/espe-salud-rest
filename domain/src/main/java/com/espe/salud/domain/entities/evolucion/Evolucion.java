package com.espe.salud.domain.entities.evolucion;

import com.espe.salud.domain.entities.catalogo.Dispensario;
import com.espe.salud.domain.entities.certificado.Certificado;
import com.espe.salud.domain.entities.enfermeria.NotaEnfermeria;
import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.domain.entities.usuario.AreaSalud;
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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
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
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%07d")})
    @Column(name = "MZSTEVO_CODIGO")
    private String codigo;

    @Column(name = "MZSTEVO_FECHA_INICIO")
    private LocalDateTime fechaInicio;

    @Enumerated(EnumType.STRING)
    @Column(name = "MZSTEVO_ESTADO")
    private EstadoNotaEvolucion estado;

    @Column(name = "MZSTEVO_FECHA_FINALIZACION")
    private LocalDateTime fechaFinalizacion;

    @Column(name = "MZSTEVO_OBSERVACION")
    private String observacion;

    @Column(name = "MZSTEVO_MOTIVO_CONSULTA")
    private String motivoConsulta;

    @Column(name = "MZSTEVO_MOTIVO_ATENCION")
    private String motivoAtencion;

    @Column(name = "MZSTEVO_NOTA_EVOLUCION", columnDefinition = "TEXT")
    private String notaEvolucion;

    @Column(name = "MZSTEVO_ES_ENFERMEDAD_OCUPACIONAL")
    private Boolean esEnfermedadOcupacional;

    @Embedded
    private Referencia referencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_CDIS_EVO", insertable = false, updatable = false)
    private Dispensario dispensario;

    @Column(name = "FK_PAC_EVO")
    private Long idPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PAC_EVO", insertable = false, updatable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_EVO_EVO", insertable = false, updatable = false)
    private Evolucion evolucionPadre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_CARESAL_EVO", insertable = false, updatable = false)
    private AreaSalud areaSalud;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_NOTENF_EVO", insertable = false, updatable = false)
    private NotaEnfermeria notaEnfermeria;

    @OneToMany(mappedBy = "evolucion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Certificado> certificados;

    @OneToMany(mappedBy = "evolucion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Diagnostico> diagnostico;

    @OneToMany(mappedBy = "evolucion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Procedimiento> procedimiento;

    @CreatedDate
    @Column(name = "MZSTEVO_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTEVO_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTEVO_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTEVO_USUARIO_MODIFICACION")
    private String usuarioModificacion;
}
