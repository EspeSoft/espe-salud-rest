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
@Table(name = "MZSTPLAFAM", schema = "SALUD")
public class PlanificacionFamiliar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="MZSTPLAFAM_CODIGO")
    private Long codigo;

    @Lob
    @Column(name = "MZSTPLAFAM_FECHA")
    private LocalDate fecha;

    @Lob
    @Column(name = "MZSTPLAFAM_VIDA_SEXUAL_ACTIVA")
    private String vidaSexualActiva;

    @Lob
    @Column(name = "MZSTPLAFAM_METODO_PLANIFICACION")
    private Boolean metodoPlanificacion;

    @Lob
    @Column(name = "MZSTPLAFAM_EDAD_INICIO_PLANIFICACION_FAMILIAR")
    private Integer edadInicioPlanificacionFamiliar;
    
    @Lob
    @Column(name = "MZSTPLAFAM_FRECUENCIA_PLANIFICACION_FAMILIAR")
    private String frecuenciaPlanificacionFamiliar;
    
    @Lob
    @Column(name = "MZSTPLAFAM_TIPO_PLANIFICACION_FAMILIAR")
    private String tipoPlanificacionFamiliar;
    
    @Lob
    @Column(name = "MZSTPLAFAM_HIJOS_VIVOS")
    private Integer hijosVivos;
    
    @Lob
    @Column(name = "MZSTPLAFAM_HIJOS_MUERTOS")
    private Integer hijosMuertos;
    
    @Lob
    @Column(name = "MZSTPLAFAM_OBSERVACION")
    private String observacion;
    
    @Lob
    @Column(name = "MZSTPLAFAM_ANTECEDENTE_PERSONAL")
    private String antecedentePersonal;

    @CreatedBy
    @Column(name = "MZSTPLAFAM_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTPLAFAM_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTPLAFAM_FECHA_CREACION")
    private LocalDate fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTPLAFAM_FECHA_MODIFICACION")
    private LocalDate fechaModificacion;
}
