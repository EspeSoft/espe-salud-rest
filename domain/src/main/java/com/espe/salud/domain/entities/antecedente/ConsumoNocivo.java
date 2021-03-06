package com.espe.salud.domain.entities.antecedente;

import com.espe.salud.domain.entities.catalogo.TipoConsumoNocivo;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MZSTCONNOC", schema = "SALUD")
public class ConsumoNocivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCONNOC_CODIGO")
    private Long codigo;

    @Column(name = "MZSTCONNOC_FECHA_REGISTRO")
    private LocalDate fechaRegistro;

    @Column(name = "MZSTCONNOC_FECHA_TENTATIVA_INICIO")
    private LocalDate fechaTentativaInicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_TIPCONNOC_CONNOC")
    private TipoConsumoNocivo nombreConsumoNocivo;

    @Column(name = "MZSTCONNOC_TIEMPO_CONSUMO_MES")
    private Integer tiempoConsumoMes;

    @Column(name = "MZSTCONNOC_FRECUENCIA_CONSUMO")
    private String frecuenciaConsumo;

    @Column(name = "MZSTCONNOC_CANTIDAD_CONSUMO")
    private Integer cantidadConsumo;

    @Column(name = "MZSTCONNOC_TIEMPO_ABSTINENCIA_MES")
    private Integer tiempoAbstinenciaMes;

    @Column(name = "MZSTCONNOC_OBSERVACION")
    private String observacion;

    @Column(name = "FK_ANTPER_CONNOC")
    private Long idAntecedentePersonal;

    @ManyToOne
    @JoinColumn(name = "FK_ANTPER_CONNOC", insertable = false, updatable = false)
    private AntecedentePersonal antecedentePersonal;

    @CreatedBy
    @Column(name = "MZSTCONNOC_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTCONNOC_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @Column(name = "MZSTCONNOC_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTCONNOC_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

}
