package com.espe.salud.domain.entities.enfermeria;


import com.espe.salud.domain.entities.catalogo.DescripcionActividadEnfermeria;
import com.espe.salud.domain.entities.catalogo.TipoActividadEnfermeria;
import com.espe.salud.domain.entities.usuario.Usuario;
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
@Table(name = "MZSTACTENF", schema = "SALUD")
public class ActividadEnfermeria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTACTENF_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTACTENF_FECHA")
    private LocalDateTime fecha;

    @Column(name = "FK_TIPACTENF_ACTENF")
    private Long idTipoActividadEnfermeria;

    @Column(name = "MZSTACTENF_DESCRIPCION")
    private String descripcion;

    @Column(name = "FK_USU_ACTENF")
    private Long idUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_TIPACTENF_ACTENF", insertable = false, updatable = false)
    private TipoActividadEnfermeria tipoActividadEnfermeria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_USU_ACTENF", insertable = false, updatable = false)
    private Usuario usuario;

    @CreatedBy
    @Column(name = "MZSTACTENF_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTACTENF_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTACTENF_FECHA_CREACION")
    private LocalDate fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTACTENF_FECHA_MODIFICACION")
    private LocalDate fechaModificacion;
}
