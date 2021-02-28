package com.espe.salud.domain.entities.enfermeria;

import com.espe.salud.domain.entities.catalogo.Dispensario;
import com.espe.salud.domain.entities.evolucion.Evolucion;
import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.domain.entities.paciente.Persona;
import com.espe.salud.domain.entities.usuario.AreaSalud;
import com.espe.salud.domain.entities.usuario.Usuario;
import com.espe.salud.domain.enums.EstadoNotaEnfermeria;
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "MZSTPAC_SIGVIT",
            joinColumns = {
                    @JoinColumn(name = "FK_NOTENF", referencedColumnName = "MZSTNOTENF_CODIGO")},
            inverseJoinColumns = {
                    @JoinColumn(name = "FK_SIGVIT", referencedColumnName = "MZSTSIGVIT_CODIGO")})
    private SignoVital signoVital;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "MZSTPAC_ANT",
            joinColumns = {
                    @JoinColumn(name = "FK_NOTENF", referencedColumnName = "MZSTNOTENF_CODIGO")},
            inverseJoinColumns = {
                    @JoinColumn(name = "FK_ANT", referencedColumnName = "MZSTANT_CODIGO")})
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

    @OneToOne(mappedBy = "notaEnfermeria", cascade = CascadeType.ALL)
    private Evolucion evolucion;

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
