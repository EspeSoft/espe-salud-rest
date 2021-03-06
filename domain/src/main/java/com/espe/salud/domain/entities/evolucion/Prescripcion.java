package com.espe.salud.domain.entities.evolucion;

import com.espe.salud.domain.entities.catalogo.RepertorioMedicamento;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "MZSTPRES", schema = "SALUD")
public class Prescripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTPRES_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTPRES_CANTIDAD")
    private Integer cantidad;

    @Column(name = "MZSTPRES_DOSIS")
    private String dosis;

    @Column(name = "MZSTPRES_PRESENTACION")
    private String presentacion;

    @Column(name = "MZSTPRES_INIDICACION")
    private String indicacion;

    private String nombreMedicamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_EVO_PRES")
    private Evolucion evolucion;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_REPMED_PRES")
    private RepertorioMedicamento medicamento;

    @CreatedDate
    @Column(name = "MZSTPRES_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTPRES_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTPRES_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTPRES_USUARIO_MODIFICACION")
    private String usuarioModificacion;

}
