package com.espe.salud.domain.entities.ocupacional;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "MZSTANTEMPANT", schema = "SALUD")
public class ActividadExtralaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTANTEMPANT_CODIGO")
    private Long codigo;

    @Column(name = "MZSTANTEMPANT_EMP")
    private String empresa;

    @Column(name = "MZSTANTEMPANT_PUESTRO_TRABAJO")
    private String puestoTrabajo;

    @Column(name = "MZSTANTEMPANT_ACTIVIDAD_DESEMPEÑABA")
    private String actividadDesempeñaba;

    @Column(name = "MZSTANTEMPANT_TIEMPO_TRABAJO_MES")
    private Integer tiempoTrabajoMes;
    
    @Column(name = "MZSTANTEMPANT_RECIBIA_VIGILANCIA")
    private Boolean recibiaVigilanciaSalud;

    @Lob
    @Column(name = "MZSTANTEMPANT_OBSERVACION")
    private String observacion;

    @Column(name = "MZSTANTEMPANT_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTANTEMPANT_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTANTEMPANT_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTANTEMPANT_FECHA_MODIFICACION")
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
