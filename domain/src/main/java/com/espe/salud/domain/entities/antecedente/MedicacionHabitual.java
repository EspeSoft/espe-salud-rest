package com.espe.salud.domain.entities.antecedente;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "MZSTMEDHAB", schema = "SALUD")
public class MedicacionHabitual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="MZSTMEDHAB_CODIGO")
    private Long codigo;

    @Lob
    @Column(name = "MZSTMEDHAB_DESCRIPCION_MEDICAMENTO")
    private String descripcionMedicamento;

    @Lob
    @Column(name = "MZSTMEDHAB_FRECUENCIA")
    private String frecuencia;

    @Column(name = "MZSTMEDHAB_CANTIDAD")
    private Integer cantidad;

    @Lob
    @Column(name = "MZSTMEDHAB_OBSERVACION")
    private String observacion;

    @Column(name = "FK_ANTPER_ANTQUI")
    private Long idAntecedentePersonal;

    @ManyToOne
    @JoinColumn(name = "FK_ANTPER_ANTQUI",insertable = false,updatable = false)
    private AntecedentePersonal antecedentePersonal;

    @CreatedBy
    @Column(name = "MZSTMEDHAB_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTMEDHAB_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTMEDHAB_FECHA_CREACION")
    private LocalDate fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTMEDHAB_FECHA_MODIFICACION")
    private LocalDate fechaModificacion;
}
