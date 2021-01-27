package com.espe.salud.domain.entities.enfermeria;

import com.espe.salud.domain.entities.catalogo.Dispensario;
import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.domain.entities.usuario.AreaSalud;
import com.espe.salud.domain.entities.usuario.Usuario;
import com.espe.salud.domain.enums.EstadoNotaEnfermeria;
import lombok.Data;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "MZSTNOTENF", schema = "SALUD")
public class NotaEnfermeria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="MZSTNOTENF_CODIGO")
    private Long codigo;

    @Column(name = "MZSTNOTENF_FECHA_INICIO")
    private LocalDateTime fechaInicio;

    @Column(name = "MZSTNOTENF_FECHA_FIN")
    private LocalDateTime fechaFin;

    @Enumerated(EnumType.STRING)
    @Column(name = "MZSTNOTENF_ESTADO")
    private EstadoNotaEnfermeria estado;

    @Column(name = "MZSTNOTENF_PRE_CONSULTA", columnDefinition = "TEXT")
    private String preConsulta;

    @Column(name = "MZSTNOTENF_POST_CONSULTA", columnDefinition = "TEXT")
    private String postConsulta;

    @Embedded
    private SignoVital signoVital;

    @Embedded
    private Antropometria antropometria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PAC_NOTENF", insertable = false, updatable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_CARESAL_NOTENF", insertable = false, updatable = false)
    private AreaSalud areaSalud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_CDIS_NOTENF", insertable = false, updatable = false)
    private Dispensario dispensario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_USU_NOTENF", insertable = false, updatable = false)
    private Usuario usuario;

    @CreatedDate
    @Column(name = "MZSTNOTENF_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTNOTENF_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTNOTENF_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTNOTENF_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @PrePersist
    void prePersist(){
        fechaInicio = LocalDateTime.now();
        estado = EstadoNotaEnfermeria.INICIADO;
    }
}
