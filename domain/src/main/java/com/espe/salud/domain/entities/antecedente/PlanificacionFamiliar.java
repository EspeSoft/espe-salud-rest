package com.espe.salud.domain.entities.antecedente;

import com.espe.salud.domain.entities.catalogo.TipoPlanificacionFamiliar;
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
@Table(name = "MZSTPLAFAM", schema = "SALUD")
public class PlanificacionFamiliar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTPLAFAM_CODIGO")
    private Long codigo;

    @Column(name = "MZSTPLAFAM_FECHA")
    private LocalDate fecha;

    @Column(name = "MZSTPLAFAM_VIDA_SEXUAL_ACTIVA")
    private String vidaSexualActiva;

    @Column(name = "MZSTPLAFAM_METODO_PLANIFICACION")
    private Boolean metodoPlanificacion;

    @Column(name = "MZSTPLAFAM_FRECUENCIA_PLANIFICACION_FAMILIAR")
    private String frecuenciaPlanificacionFamiliar;

    @Column(name = "MZSTPLAFAM_EDAD_INICIO_PLANIFICACION_FAMILIAR")
    private Integer edadInicioPlanificacionFamiliar;

    @Column(name = "FK_TIPPLAFAM_PLAFAM")
    private Long idTipoPlanificacionFamiliar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_TIPPLAFAM_PLAFAM", insertable = false, updatable = false, nullable = false)
    private TipoPlanificacionFamiliar tipoPlanificacionFamiliar;

    @Column(name = "MZSTPLAFAM_HIJOS_VIVOS")
    private Integer hijosVivos;

    @Column(name = "MZSTPLAFAM_HIJOS_MUERTOS")
    private Integer hijosMuertos;

    @Column(name = "MZSTPLAFAM_OBSERVACION")
    private String observacion;

    @Column(name = "FK_ANTPER_PLAFAM")
    private Long idAntecedentePersonal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ANTPER_PLAFAM", insertable = false, updatable = false, nullable = false)
    private AntecedentePersonal antecedentePersonal;

    @CreatedBy
    @Column(name = "MZSTPLAFAM_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTPLAFAM_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTPLAFAM_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTPLAFAM_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;
}
