package com.espe.salud.domain.entities.ocupacional;

import com.espe.salud.domain.entities.usuario.Usuario;
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
@Table(name = "MZSTANTEMPANT", schema = "SALUD")
public class AntecedenteEmpleoAnterior extends DetalleTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTANTEMPANT_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "FK_ANTLAB_ANTEMPANT")
    private Long idAntecedenteLaboral;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ANTLAB_ANTEMPANT", insertable = false, updatable = false)
    private AntecedenteLaboral antecedenteLaboral;

    @CreatedDate
    @Column(name = "MZSTANTEMPANT_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTANTEMPANT_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTANTEMPANT_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTANTEMPANT_USUARIO_MODIFICACION")
    private String usuarioModificacion;

}
