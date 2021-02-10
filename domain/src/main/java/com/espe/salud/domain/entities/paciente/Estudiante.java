package com.espe.salud.domain.entities.paciente;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "MZSTEST", schema = "SALUD")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTEST_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTEST_FECHA_INGRESO_ESPE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate fechaIngresoEspe;

    @Column(name = "MZSTEST_DEPARTAMENTO")
    @NotEmpty
    private String departamento;

    @Column(name = "MZSTEST_ESCUELA")
    private String escuela;

    @Column(name = "MZSTEST_CARRERA")
    @NotEmpty
    private String carrera;

    @Column(name = "MZSTEST_ACTIVIDADES_RELEVANTES")
    private String actividadesRelevantes;

    @Column(name = "MZSTEST_PARROQUIA")
    private String parroquia;

    @Column(name = "MZSTEST_DIRECCION_LUGAR_ESTUDIO")
    private String direccionLugarEstudio;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_PAC_EST", updatable = false, insertable = false)
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
