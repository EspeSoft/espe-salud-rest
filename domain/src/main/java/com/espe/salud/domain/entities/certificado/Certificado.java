package com.espe.salud.domain.entities.certificado;

import com.espe.salud.domain.entities.catalogo.TipoCertificado;
import com.espe.salud.domain.entities.evolucion.Evolucion;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MZSTCER", schema = "SALUD")
public class Certificado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="MZSTCER_CODIGO")
    private Long codigo;

    @Column(name = "MZSTCER_FECHA_DESDE")
    private LocalDateTime fechaDesde;

    @Column(name = "MZSTCER_FECHA_HASTA")
    private LocalDateTime fechaHasta;

    @NotEmpty
    @Column(name = "MZSTCER_INSTITUCION_EMITE")
    private String institucionEmite;

    @NotNull
    @Column(name = "MZSTCER_DIAS_REPOSO")
    private Integer diasReposo;

    @NotNull
    @Column(name = "MZSTCER_EQUIVALENTE_HORAS_LABORABLES")
    private Integer equivalenteHorasLaborables;

    @NotEmpty
    @Column(name = "MZSTCER_DIAGNOSTICO_CIE10")
    private String diagnosticoCie10;


    @Column(name = "MZSTCER_FECHA_REGISTRO")
    private LocalDateTime fechaRegistro;

    @CreatedBy
    @Column(name = "MZSTCER_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTCER_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTCER_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTCER_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @Column(name = "FK_TIPCER_CER")
    private Long idTipoCertificado;

    @ManyToOne
    @JoinColumn(name = "FK_TIPCER_CER", insertable = false, updatable = false)
    private TipoCertificado tipoCertificado;

    @Column(name = "FK_EVO_CER")
    private String idEvolucion;

    @ManyToOne
    @JoinColumn(name = "FK_EVO_CER", insertable = false, updatable = false)
    private Evolucion evolucion;

}
