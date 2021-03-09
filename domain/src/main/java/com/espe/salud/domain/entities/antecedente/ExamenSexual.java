package com.espe.salud.domain.entities.antecedente;

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
@Table(name = "MZSTEXASEX", schema = "SALUD")
public class ExamenSexual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTEXASEX_CODIGO")
    private Long codigo;

    @Column(name = "MZSTEXASEX_FECHA")
    private LocalDate fecha;

    @Lob
    @Column(name = "MZSTEXASEX_NOMBRE_EXAMEN")
    private String nombreExamen;

    @Column(name = "MZSTEXASEX_TIEMPO_ANIOS")
    private Integer tiempoAnios;

    @Column(name = "MZSTEXASEX_RESULTADO", columnDefinition = "TEXT")
    private String resultado;

    @Column(name = "FK_ANTPER_EXASEX")
    private Long idAntecedentePersonal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ANTPER_EXASEX", insertable = false, updatable = false, nullable = false)
    private AntecedentePersonal antecedentePersonal;

    @CreatedBy
    @Column(name = "MZSTEXASEX_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTEXASEX_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTEXASEX_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTEXASEX_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;
}
