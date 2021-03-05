package com.espe.salud.domain.entities.antecedente;

import com.espe.salud.domain.entities.catalogo.EnfermedadCIE10;
import com.espe.salud.domain.entities.catalogo.TipoEnfermedad;
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
@Table(name = "MZSTANTPATFAM", schema = "SALUD")
public class AntecedentePatologicoFamiliar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTANTPATFAM_CODIGO")
    private Long codigo;

    @Column(name = "MZSTANTPATFAM_PARENTESCO")
    private String parentesco;

    @Column(name = "MZSTANTPATFAM_OBSERVACION", columnDefinition = "TEXT")
    private String observacion;

    @Column(name = "FK_ENFCIE10_ANTPATFAM")
    private String idDiagnostico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ENFCIE10_ANTPATFAM", insertable = false, updatable = false, nullable = false)
    private EnfermedadCIE10 diagnostico;

    @Column(name = "FK_TIPENF_ANTPATFAM")
    private Long idTipoEnfermedadFamiliar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_TIPENF_ANTPATFAM", insertable = false, updatable = false, nullable = false)
    private TipoEnfermedad tipoEnfermedadFamiliar;

    @Column(name = "FK_ANTPER_ANTPATFAM")
    private Long idAntecedentePersonal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ANTPER_ANTPATFAM", insertable = false, updatable = false, nullable = false)
    private AntecedentePersonal antecedentePersonal;

    @CreatedBy
    @Column(name = "MZSTPATFAM_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTPATFAM_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTPATFAM_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTPATFAM_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;
}