package com.espe.salud.domain.entities.evolucion;

import com.espe.salud.domain.entities.catalogo.Area;
import com.espe.salud.domain.entities.catalogo.OrganoSistema;
import com.espe.salud.domain.entities.catalogo.Region;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MZSTEXAINT", schema = "SALUD")
public class ExamenInterno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTEXAINT_CODIGO")
    private Long codigo;

    @Column(name = "MZSTEXAINT_DESCRIPCION")
    private String descripcion;

    @JoinColumn(name = "FK_EVO_EXAINT", updatable = false, insertable = false)
    @ManyToOne
    private Evolucion evolucion;

    // TODO Agregar la relacion con organo sistema

    @CreatedDate
    @Column(name = "MZSTEXAINT_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTEXAINT_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTEXAINT_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTEXAINT_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @Column(name = "FK_ORGSIS_EXAINT")
    private String idOrganoSistema;

    //relaciones

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ORGSIS_EXAINT", insertable = false, updatable = false, nullable = false)
    private OrganoSistema organoSistema;


}
