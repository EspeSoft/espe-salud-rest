package com.espe.salud.domain.entities.ocupacional;

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
@Table(name = "MZSTANTLAB", schema = "SALUD")
public class AntecedenteLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTANTLAB_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @CreatedDate
    @Column(name = "MZSTANTLAB_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTANTLAB_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTANTLAB_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTANTLAB_USUARIO_MODIFICACION")
    private String usuarioModificacion;
}
