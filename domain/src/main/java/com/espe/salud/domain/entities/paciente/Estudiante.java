package com.espe.salud.domain.entities.paciente;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MZSTEST", schema = "SALUD")
public class Estudiante {

    @Id
    @Column(name = "MZSTEST_CODIGO")
    private Long codigo;

    @Column(name = "MZSTEST_FECHA_INGRESO_ESPE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaIngresoEspe;

    @Column(name = "MZSTEST_DEPARTAMENTO")
    private String departamento;

    @Column(name = "MZSTEST_ESCUELA")
    private String escuela;

    @Column(name = "MZSTEST_CARRERA")
    private String carrera;

    @Column(name = "MZSTEST_ACTIVIDADES_RELEVANTES")
    private String actividadesRelevantes;

    @Column(name = "MZSTEST_CAMPUS")
    private String campus;

    @Column(name = "MZSTEST_DIRECCION_LUGAR_ESTUDIO")
    private String direccionLugarEstudio;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PAC_EST", updatable = false, insertable = false)
    @MapsId
    private Paciente paciente;

    @CreatedDate
    @Column(name = "MZSTEST_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTEST_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTEST_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTEST_USUARIO_MODIFICACION")
    private String usuarioModificacion;
}
