package com.espe.salud.domain.entities.enfermeria;

import com.espe.salud.domain.enums.EstadoNotaEnfermeria;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
//@Entity
//@Table(name = "MZSTNOTENF", schema = "SALUD",
//        indexes = {@Index(name = "i_responsable_pidm", columnList = "responsable_pidm")})
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

    @Column(name = "pre_consulta", columnDefinition="LONGTEXT")
    private String preConsulta;

    @Column(name = "post_consulta", columnDefinition="LONGTEXT")
    private String postConsulta;

//    @Embedded
//    private SignoVital signoVital;
//
//    @Embedded
//    private Antropometria antropometria;

    @Column(name = "responsable_pidm")
    private Long responsablePidm;

    @PrePersist
    void prePersist(){
        fechaInicio = LocalDateTime.now();
        estado = EstadoNotaEnfermeria.INICIADO;
    }
}
