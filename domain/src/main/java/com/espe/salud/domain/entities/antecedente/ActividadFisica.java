package com.espe.salud.domain.entities.antecedente;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "MZSTACTFIS", schema = "SALUD")
public class ActividadFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTACTFIS_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTACTFIS_NOMBRE_ACTIVIDAD")
    @NotEmpty
    private String nombreActividad;

    @Column(name = "MZSTACTFIS_FRECUENCIA")
    @NotEmpty
    private String frecuencia;

    @Column(name = "MZSTACTFIS_HORAS")
    @NotNull
    private Integer horas;

    @Column(name = "MZSTACTFIS_OBSERVACION")
    @NotEmpty
    private String observacion;

    @Column(name = "FK_ANTPATPER_ACTFIS")
    private Long idAntecedentePersonal;

    @ManyToOne
    @JoinColumn(name = "FK_ANTPATPER_ACTFIS", insertable = false, updatable = false)
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

    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = LocalDateTime.now();
    }
}
