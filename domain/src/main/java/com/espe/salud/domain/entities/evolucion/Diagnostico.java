package com.espe.salud.domain.entities.evolucion;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MZSTDIA", schema = "SALUD")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTDIA_CODIGO")
    private Long codigo;

    @NotNull
    @Column(name = "MZSTDIA_CODIGO_CIE")
    private String codigoCie;

    @NotNull
    @Column(name = "MZSTDIA_PREVENCION")
    private String prevencion;

    @NotNull
    @Column(name = "MZSTDIA_MORBILIDAD")
    private String morbilidad;

    @NotNull
    @Column(name = "MZSTDIA_CONDICION_DIAGNOSTICO")
    private String condicionDiagnostico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FX_EVO_DIA", updatable = false, insertable = false)
    private Evolucion evolucion;

    @CreatedDate
    @Column(name = "MZSTDIA_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTDIA_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTDIA_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTDIA_USUARIO_MODIFICACION")
    private String usuarioModificacion;
}
