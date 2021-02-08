package com.espe.salud.domain.entities.evolucion;

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
@Table(name = "MZSTEXAEXT", schema = "SALUD")
public class ExamenExterno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTEXAEXT_CODIGO")
    private Long codigo;

    @Column(name = "MZSTEXAEXT_DESCRIPCION")
    private String descripcion;

    @JoinColumn(name = "FK_EVO_EXAEXT", updatable = false, insertable = false)
    @ManyToOne
    private Evolucion evolucion;

    // TODO Agregar la relacion con region y area

    @CreatedDate
    @Column(name = "MZSTEXAEXT_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTEXAEXT_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTEXAEXT_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTEXAEXT_USUARIO_MODIFICACION")
    private String usuarioModificacion;
}
