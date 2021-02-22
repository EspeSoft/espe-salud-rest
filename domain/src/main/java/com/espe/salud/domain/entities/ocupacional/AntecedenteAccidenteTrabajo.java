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
@Table(name = "MZSTANTACCTRA", schema = "SALUD")
public class AntecedenteAccidenteTrabajo extends DetalleAntecedente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTANTACCTRA_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @CreatedDate
    @Column(name = "MZSTANTACCTRA_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTANTACCTRA_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTANTACCTRA_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTANTACCTRA_USUARIO_MODIFICACION")
    private String usuarioModificacion;

}
