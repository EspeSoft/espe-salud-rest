package com.espe.salud.domain.entities.paciente;

import com.espe.salud.domain.entities.evolucion.Evolucion;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "MZSTPAC", schema = "SALUD")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTPAC_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTPAC_NUMERO_ARCHIVO", unique = true)
    private String numeroArchivo;

    @Column(name = "MZSTPAC_ACTIVO")
    private Boolean activo;

    @Column(name = "MZSTPAC_ES_ESTUDIANTE")
    private Boolean esEstudiante;

    @Column(name = "MZSTPAC_ES_EMPLEADO")
    private Boolean esEmpleado;

    @Column(name = "MZSTPAC_ACCESO_BANNER")
    private Boolean accesoBanner;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Evolucion> evoluciones;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_PER_PAC", updatable = false, nullable = false)
    private Persona persona;

    @CreatedDate
    @Column(name = "MZSTPAC_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTPAC_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTPAC_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTPAC_USUARIO_MODIFICACION")
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
