package com.espe.salud.domain.entities.evolucion;

import com.espe.salud.domain.entities.catalogo.EnfermedadCIE10;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @Column(name = "FK_ENFCIE10_DIA")
    @NotEmpty
    private String codigoCIE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ENFCIE10_DIA", insertable = false, updatable = false, nullable = false)
    private EnfermedadCIE10 cie10;

    @Column(name = "MZSTDIA_PREVENCION")
    @NotEmpty
    private String prevencion;

    @Column(name = "MZSTDIA_PMORBILIDAD")
    private String morbilidad;

    @Column(name = "MZSTDIA_CONDICION__DIAGNOSTICO")
    private String condicionDiagnostico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_EVO_DIA")
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
