package com.espe.salud.domain.entities.antecedente;

import com.espe.salud.domain.entities.catalogo.EnfermedadCIE10;
import com.espe.salud.domain.enums.TipoColaboradorDiscapacidad;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MZSTDIS", schema = "SALUD")
public class Discapacidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTDIS_CODIGO")
    private Long codigo;

    @Column(name = "MZSTDIS_TIPO_COLABORADOR")
    @Enumerated(EnumType.STRING)
    private TipoColaboradorDiscapacidad tipoColaborador;

    @Column(name = "MZSTDIS_TIPO_DISCAPACIDAD")
    private String tipoDiscapacidad;

    @Column(name = "MZSTDIS_PORCENTAJE_DISCAPACIDAD")
    private String porcentajeDiscapacidad;

    @Column(name = "MZSTDIS_GRADO_DISCAPACIDAD")
    private String gradoDiscapacidad;

    @Column(name = "FK_ANTPER_DIS")
    private Long idAntecedentePersonal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ANTPER_DIS", insertable = false, updatable = false, nullable = false)
    private AntecedentePersonal antecedentePersonal;

    @Column(name = "FK_ENFCIE10_DIS")
    private String idDiagnosticoRelacionDiscapacidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ENFCIE10_DIS", insertable = false, updatable = false, nullable = false)
    private EnfermedadCIE10 diagnosticoRelacionDiscapacidad;

    @CreatedBy
    @Column(name = "MZSTDIS_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTDIS_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTDIS_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTDIS_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;
}