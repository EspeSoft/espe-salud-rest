package com.espe.salud.domain.entities.antecedente;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MZSTACTFIS", schema = "SALUD")
public class ActividadFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTACTFIS_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTACTFIS_NOMBRE_ACTIVIDAD")
    private String nombreActividad;

    @Column(name = "MZSTACTFIS_FRECUENCIA")
    private String frecuencia;

    @Column(name = "MZSTACTFIS_HORAS")
    private Integer horas;

    @Column(name = "MZSTACTFIS_OBSERVACION")
    private String observacion;

    @Column(name = "FK_ANTPER_ACTFIS")
    private Long idAntecedentePersonal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ANTPER_ACTFIS", insertable = false, updatable = false, nullable = false)
    private AntecedentePersonal antecedentePersonal;

    @CreatedBy
    @Column(name = "MZSTACTFIS_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTACTFIS_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @Column(name = "MZSTACTFIS_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTACTFIS_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;
}
