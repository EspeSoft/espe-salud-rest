package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.evolucion.ExamenExterno;
import com.espe.salud.domain.entities.evolucion.ExamenInterno;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MZSTCORGSIS", schema = "SALUD")
public class OrganoSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCORGSIS_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCORGSIS_NOMBRE")
    private String nombre;

    //FALTAN LAS RELACIONES EXAMENEXTERNO NO EXISTE

    @CreatedDate
    @Column(name = "MZSTCORGSIS_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTCORGSIS_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTCORGSIS_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTCORGSIS_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = LocalDateTime.now();
    }

    //relaciones
    @OneToMany(mappedBy = "organoSistema", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ExamenInterno> examenesInternos;
}
