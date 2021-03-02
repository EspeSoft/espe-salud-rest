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
@Table(name = "MZSTDIS", schema = "SALUD")
public class Discapacidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTDIS_CODIGO")
    private Long codigo;

    @Column(name = "MZSTDIS_COLABORADOR_DISCAPACIDAD")
    private Boolean colaboradorDiscapacidad;

    @Column(name = "MZSTDIS_ES_COLABORADOR_SUSTITUTO")
    private Boolean esColaboradorSustituto;

    @Lob
    @Column(name = "MZSTDIS_DIAGNOSTICO_RELACION_DISCAPACIDAD")
    private String diagnosticoRelacionDiscapacidad;

    @Lob
    @Column(name = "MZSTDIS_TIPO_DISCAPACIDAD")
    private String tipoDiscapacidad;

    @Lob
    @Column(name = "MZSTDIS_PORCENTAJE_DISCAPACIDAD")
    private String porcentajeDiscapacidad;

    @Lob
    @Column(name = "MZSTDIS_GRADO_DISCAPACIDAD")
    private String gradoDiscapacidad;

    @Column(name = "FK_MZSTANTPATPER_ANTECEDENTE_PERSONAL")
    private Long idAntecedentePersonal;

    @ManyToOne
    @JoinColumn(name = "FK_MZSTANTPATPER_ANTECEDENTE_PERSONAL", insertable = false, updatable = false)
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