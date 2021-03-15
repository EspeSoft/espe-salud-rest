package com.espe.salud.domain.entities.antecedente;

import com.espe.salud.domain.enums.CicloMenstruacion;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MZSTANTGIN", schema = "SALUD")
public class AntecedenteGinecologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTANTGIN_CODIGO")
    private Long codigo;

    @Column(name = "MZSTANTGIN_FECHA")
    private LocalDate fecha;

    @Column(name = "MZSTANTGIN_EDAD_MENARQUIA")
    private Integer edadMenarquia;

    @Column(name = "MZSTANTGIN_CICLO_MENSTRUACION")
    @Enumerated(EnumType.STRING)
    private CicloMenstruacion cicloMenstruacion;

    @Column(name = "MZSTANTGIN_FECHA_ULTIMA_MENSTRUACION")
    private LocalDate fechaUltimaMenstruacion;

    @Column(name = "MZSTANTGIN_GESTAS")
    private Integer gestas;

    @Column(name = "MZSTANTGIN_NUMERO_PARTOS_VAGINALES")
    private Integer numeroPartosVaginales;

    @Column(name = "MZSTANTGIN_NUMERO_CESAREAS")
    private Integer numeroCesareas;

    @Column(name = "MZSTANTGIN_NUMERO_ABORTOS")
    private Integer numeroAbortos;

    @Column(name = "MZSTANTGIN_HIJOS_MUERTOS")
    private Integer hijosMuertos;

    @Column(name = "MZSTANTGIN_HIJOS_VIVOS")
    private Integer hijosVivos;

    @Column(name = "FK_ANTPER_ANTGIN")
    private Long idAntecedentePersonal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ANTPER_ANTGIN", insertable = false, updatable = false, nullable = false)
    private AntecedentePersonal antecedentePersonal;

    @CreatedBy
    @Column(name = "MZSTANTGIN_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTANTGIN_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTANTGIN_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTANTGIN_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @PrePersist
    void prePersist() {
        fecha = LocalDate.now();
    }
}
