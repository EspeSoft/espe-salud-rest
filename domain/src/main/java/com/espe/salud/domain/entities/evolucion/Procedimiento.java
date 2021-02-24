package com.espe.salud.domain.entities.evolucion;

import com.espe.salud.domain.entities.catalogo.Area;
import com.espe.salud.domain.entities.catalogo.TipoProcedimiento;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "MZSTPRO", schema = "SALUD")
public class Procedimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTPRO_CODIGO")
    private Long codigo;



    @Column(name = "MZSTPRO_NUMERO_ACTIVIDAD")
    @NotNull
    private Integer numeroActividades;

    @Column(name = "MZSTPRO_NOTA")
    private String nota;

    //@Column(name = "MZSTPRO_ID_RESPONSANBLE")  //TO DO idResponsable
    //@NotNull
    //private Long idResponsable;

    @CreatedBy
    @Column(name = "MZSTPRO_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTPRO_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTPRO_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTPRO_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = LocalDateTime.now();
    }

    @Column(name = "FK_TIPPROC_PROC")
    private String idTipoProcedimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_TIPPROC_PROC", insertable = false, updatable = false, nullable = false)
    private TipoProcedimiento tipoProcedimiento;


}
