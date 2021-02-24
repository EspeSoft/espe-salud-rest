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
@Table(name = "MZSTEXASEX", schema = "SALUD")
public class ExamenSexual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="MZSTEXASEX_CODIGO")
    private Long codigo;

    @Lob
    @Column(name = "MZSTEXASEX_FECHA")
    private LocalDate fecha;
    
    @Lob
    @Column(name = "MZSTEXASEX_NOMBRE_EXAMEN")
    private String nombreExamen;

    @Lob
    @Column(name = "MZSTEXASEX_REALIZADO")
    private Boolean realizado;

    @Lob
    @Column(name = "MZSTEXASEX_TIEMPO_ANIOS")
    private Integer tiempoAnios;

    @Lob
    @Column(name = "MZSTEXASEX_RESULTADO")
    private String resuldato;

    @ManyToOne
    @JoinColumn(name = "FK_MZSTEXASEX_ANTECEDENTE_PERSONAL",insertable = false,updatable = false)
    private AntecedentePersonal antecedentePersonal;

    @CreatedBy
    @Column(name = "MZSTEXASEX_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTEXASEX_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTEXASEX_FECHA_CREACION")
    private LocalDate fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTEXASEX_FECHA_MODIFICACION")
    private LocalDate fechaModificacion;
}
