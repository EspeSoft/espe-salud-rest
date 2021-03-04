package com.espe.salud.domain.entities.antecedente;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "MZSTCONNOC", schema = "SALUD")
public class ConsumoNocivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCONNOC_CODIGO")
    private Long codigo;

    @Column(name = "MZSTCONNOC_NOMBRE_NOCIVO")
    @NotEmpty
    private String nombreConsumoNocivo;

    @Column(name = "MZSTCONNOC_CONSUMO")
    private String consume;

    @Column(name = "MZSTCONNOC_TIEMPO_CONSUMO_MES")
    @NotNull
    private Integer tiempoConsumoMes;

    @Column(name = "MZSTCONNOC_FRECUENCIA_CONSUMO")
    @NotEmpty
    private String frecuenciaConsumo;

    @Column(name = "MZSTCONNOC_CANTIDAD_CONSUMO")
    @NotNull
    private Integer cantidadConsumo;

    @Column(name = "MZSTCONNOC_EXCONSUMO")
    @NotEmpty
    private String exConsumidor;

    @Column(name = "MZSTCONNOC_TIEMPO_ABSTINENCIA_MES")
    @NotNull
    private Integer tiempoAbstinenciaMes;

    @Column(name = "MZSTCONNOC_OBSERVACION")
    @NotEmpty
    private String observacion;

    @Column(name = "FK_ANTPATPER_CONNOC")
    private Long idAntecedentePersonal;

    @ManyToOne
    @JoinColumn(name = "FK_ANTPATPER_CONNOC", insertable = false, updatable = false)
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

    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = LocalDateTime.now();
    }


}
