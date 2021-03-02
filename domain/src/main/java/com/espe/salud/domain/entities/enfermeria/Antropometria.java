package com.espe.salud.domain.entities.enfermeria;

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
@Table(name = "MZSTANT", schema = "SALUD")
public class Antropometria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTANT_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTANT_PESO")
    private Double peso;

    @Column(name = "MZSTANT_TALLA")
    private Double talla;

    @Column(name = "MZSTANT_INDICE_MASA_CORPORAL")
    private Double indiceMasaCorporal;

    @Column(name = "MZSTANT_PERIMETRO_ABDOMINAL")
    private Double perimetroAbdominal;

    @OneToOne(mappedBy = "antropometria")
    private NotaEnfermeria notaEnfermeria;

    @CreatedDate
    @Column(name = "MZSTANT_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTANT_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTANT_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTANT_USUARIO_MODIFICACION")
    private String usuarioModificacion;
}
