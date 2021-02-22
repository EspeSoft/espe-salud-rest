package com.espe.salud.domain.entities.paciente;

import com.espe.salud.domain.entities.antecedente.EstudioComplementario;
import com.espe.salud.domain.entities.evolucion.Evolucion;
import com.espe.salud.domain.entities.odontologia.HistoriaClinicaOdontologica;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "MZSTPAC_PER",
            joinColumns = {
                    @JoinColumn(name = "FK_PAC", referencedColumnName = "MZSTPAC_CODIGO")},
            inverseJoinColumns = {
                    @JoinColumn(name = "FK_PER", referencedColumnName = "MZSTPER_CODIGO")})
    private Persona persona;

    @OneToOne(mappedBy = "paciente")
    private Estudiante estudiante;

    @OneToOne(mappedBy = "paciente")
    private Empleado empleado;

    @OneToOne(mappedBy = "paciente")
    private HistoriaClinicaOdontologica historiaClinicaOdontologica;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Evolucion> evoluciones;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EstudioComplementario> estudiosComplementarios;

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
        this.activo = true;
    }
}
