package com.espe.salud.domain.entities.examen;

import com.espe.salud.domain.entities.catalogo.Area;
import com.espe.salud.domain.entities.catalogo.Region;
import com.espe.salud.domain.entities.paciente.Paciente;
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
@Table(name = "MZSTEXAEXT", schema = "SALUD")
public class ExamenExterno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTEXAEXT_CODIGO")
    private Long codigo;

    @Column(name = "MZSTEXAEXT_DESCRIPCION", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "MZSTEXAEXT_FECHA_REGISTRO")
    private LocalDateTime fechaRegistro;

    @Column(name = "FK_PAC_EXAEXT")
    private Long idPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PAC_EXAEXT", updatable = false, insertable = false, nullable = false)
    private Paciente paciente;

    @Column(name = "FK_ARE_EXAEXT")
    private Long idArea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ARE_EXAEXT", insertable = false, updatable = false, nullable = false)
    private Area area;

    @Column(name = "FK_REG_EXAEXT")
    private Long idRegion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_REG_EXAEXT", insertable = false, updatable = false, nullable = false)
    private Region region;

    @CreatedDate
    @Column(name = "MZSTEXAEXT_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTEXAEXT_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTEXAEXT_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTEXAEXT_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @PrePersist
    public void prePersist() {
        fechaRegistro = LocalDateTime.now();
    }
}
