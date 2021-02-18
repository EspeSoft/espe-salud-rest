package com.espe.salud.domain.entities.antecedente;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;

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
    @Column(name = "MZSTPATFAM_TIPO_ENFERMEDAD")
    private String tipoEnfermedad;

    @Lob
    @Column(name = "MZSTPATFAM_PARENTEZCO")
    private String parentezco;

    @Lob
    @Column(name = "MZSTPATFAM_DIAGNOSTICO")
    private String diagnostico;

    @Lob
    @Column(name = "MZSTPATFAM_OBSERVACION")
    private String observacion;

    @Column(name = "FK_MZSTPATFAM_ANTECEDENTE_PERSONAL")
    private Long idAntecedentePersonal;

    @ManyToOne
    @JoinColumn(name = "FK_MZSTPATFAM_ANTECEDENTE_PERSONAL",insertable = false,updatable = false)
    private AntecedentePersonal antecedentePersonal;

    @CreatedBy
    @Column(name = "MZSTPATFAM_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTPATFAM_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTPATFAM_FECHA_CREACION")
    private LocalDate fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTPATFAM_FECHA_MODIFICACION")
    private LocalDate fechaModificacion;

}