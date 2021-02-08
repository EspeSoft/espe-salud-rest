package com.espe.salud.domain.entities.catalogo;

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
@Table(name = "MZSTCREGION", schema = "SALUD")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCREGION_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCREGION_NOMBRE")
    private String nombre;

    //FALTAN LAS RELACIONES EXAMENEXTERNO NO EXISTE

    @CreatedDate
    @Column(name = "MZSTCREGION_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTCREGION_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTCREGION_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTCREGION_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = LocalDateTime.now();
    }

}
