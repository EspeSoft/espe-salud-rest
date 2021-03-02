package com.espe.salud.domain.entities.antecedente;

import com.espe.salud.domain.entities.catalogo.TipoEnfermedad;
import com.espe.salud.domain.entities.paciente.Paciente;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "MZSTPATFAM", schema = "SALUD")
public class AntecedentePatologicoFamiliar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="MZSTPATFAM_CODIGO")
    private Long codigo;

    @Lob
    @Column(name = "MZSTPATFAM_PARENTEZCO")
    private String parentezco;

    @Lob
    @Column(name = "MZSTPATFAM_DIAGNOSTICO")
    private String diagnostico;

    @Lob
    @Column(name = "MZSTPATFAM_OBSERVACION")
    private String observacion;

    @Column(name = "FK_ANTPER_ANTQUI")
    private Long idAntecedentePersonal;

    @ManyToOne
    @JoinColumn(name = "FK_ANTPER_ANTQUI",insertable = false,updatable = false)
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

    @Column(name = "FK_TIPENF_PATFAM")
    private Long idTipoEnfermedadFamilia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_TIPENF_PATFAM", insertable = false, updatable = false, nullable = false)
    private TipoEnfermedad tipoEnfermedad;

}