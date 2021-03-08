package com.espe.salud.domain.entities.antecedente;

import com.espe.salud.domain.entities.catalogo.EnfermedadCIE10;
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
@Table(name = "MZSTANTQUI", schema = "SALUD")
public class AntecedenteQuirurgico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTANTQUI_CODIGO")
    private Long codigo;

    @Column(name = "FK_ENFCIE10_ANTQUI")
    private String idDiagnosticoPreQuirurgico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ENFCIE10_ANTQUI", insertable = false, updatable = false, nullable = false)
    private EnfermedadCIE10 diagnosticoPreQuirurgico;

    @Column(name = "MZSTANTQUI_PROCEDIMIENTO_QUIRURGICO")
    private String procedimientoQuirurgico;

    @Column(name = "MZSTANTQUI_FECHA_PROCEDIMIENTO")
    private LocalDate fechaProcedimiento;

    @Column(name = "MZSTANTQUI_SECUELAS")
    private String secuelas;

    @Column(name = "FK_ANTPER_ANTQUI")
    private Long idAntecedentePersonal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ANTPER_ANTQUI",insertable = false, updatable = false, nullable = false)
    private AntecedentePersonal antecedentePersonal;

    @CreatedBy
    @Column(name = "MZSTANTQUI_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTANTQUI_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTANTQUI_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTANTQUI_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;
}