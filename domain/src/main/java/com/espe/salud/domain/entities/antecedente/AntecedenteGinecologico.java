package com.espe.salud.domain.entities.antecedente;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "MZSTANTGIN", schema = "SALUD")
public class AntecedenteGinecologico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTANTGIN_CODIGO")
    private Long codigo;

    @Lob
    @Column(name = "MZSTANTGIN_EDAD_MENARQUIA")
    private Integer edadMenarquia;

    @Lob
    @Column(name = "MZSTANTGIN_CICLO_MENSTRUACION")
    private String cicloMenstruacion;

    @Lob
    @Column(name = "MZSTANTGIN_FECHA_ULTIMA_MENSTRUACION")
    private LocalDate fechaUltimaMenstruacion;

    @Lob
    @Column(name = "MZSTANTGIN_GESTAS")
    private Integer gestas;

    @Lob
    @Column(name = "MZSTANTGIN_NUMERO_PARTOS_VAGINALES")
    private Integer numeroPartosVaginales;

    @Lob
    @Column(name = "MZSTANTGIN_NUMERO_CESAREAS")
    private Integer numeroCesareas;

    @Lob
    @Column(name = "MZSTANTGIN_NUMERO_ABORTOS")
    private Integer numeroAbortos;

    @CreatedBy
    @Column(name = "MZSTANTGIN_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTANTGIN_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTANTGIN_FECHA_CREACION")
    private LocalDate fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTANTGIN_FECHA_MODIFICACION")
    private LocalDate fechaModificacion;
}
