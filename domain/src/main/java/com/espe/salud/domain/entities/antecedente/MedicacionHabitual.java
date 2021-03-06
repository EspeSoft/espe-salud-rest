package com.espe.salud.domain.entities.antecedente;

import com.espe.salud.domain.entities.catalogo.FrecuenciaMedicacionHabitual;
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
@Table(name = "MZSTMEDHAB", schema = "SALUD")
public class MedicacionHabitual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTMEDHAB_CODIGO")
    private Long codigo;

    @Column(name = "MZSTMEDHAB_DESCRIPCION_MEDICAMENTO")
    private String descripcionMedicamento;

    @Column(name = "FK_FREMEDHAB_MEDHAB")
    private Long idFrecuencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_FREMEDHAB_MEDHAB", insertable = false, updatable = false, nullable = false)
    private FrecuenciaMedicacionHabitual frecuencia;

    @Column(name = "MZSTMEDHAB_CANTIDAD")
    private Integer cantidad;

    @Column(name = "MZSTMEDHAB_OBSERVACION")
    private String observacion;

    @Column(name = "FK_ANTPER_MEDHAB")
    private Long idAntecedentePersonal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ANTPER_MEDHAB",insertable = false,updatable = false)
    private AntecedentePersonal antecedentePersonal;

    @CreatedBy
    @Column(name = "MZSTMEDHAB_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTMEDHAB_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTMEDHAB_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTMEDHAB_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;
}
