package com.espe.salud.domain.entities.antecedente;

import com.espe.salud.domain.entities.catalogo.EnfermedadCIE10;
import com.espe.salud.domain.entities.catalogo.TipoEnfermedadPersonal;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MZSTANTPATPER", schema = "SALUD")
public class AntecedentePatologicoPersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="MZSTANTPATPER_CODIGO")
    private Long codigo;

    @Column(name = "MZSTANTPATPER_FECHA_DIAGNOSTICO")
    private LocalDate fechaDiagnostico;

    @Column(name = "MZSTANTPATPER_FRECUENCIA_MEDICACION")
    private String frecuenciaMedicacion;

    @Column(name = "MZSTANTPATPER_OBSERVACIONES")
    private String observaciones;

    @Column(name = "FK_ENFCIE10_ANTPATPER")
    private String idDiagnostico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ENFCIE10_ANTPATPER", insertable = false, updatable = false, nullable = false)
    private EnfermedadCIE10 diagnostico;

    @Column(name = "FK_TIPENFPER_ANTPATPER")
    private Long idTipoEnfermedadPersonal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_TIPENFPER_ANTPATPER", insertable = false, updatable = false, nullable = false)
    private TipoEnfermedadPersonal tipoEnfermedadPersonal;

    @Column(name = "FK_ANTPER_ANTPATPER")
    private Long idAntecedentePersonal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ANTPER_ANTPATPER", insertable = false, updatable = false, nullable = false)
    private AntecedentePersonal antecedentePersonal;

    @CreatedBy
    @Column(name = "MZSTANTPATPER_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTANTPATPER_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTANTPATPER_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTANTPATPER_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;
}
