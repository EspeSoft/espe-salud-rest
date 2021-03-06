package com.espe.salud.domain.entities.paciente;

import com.espe.salud.domain.entities.antecedente.EstudioComplementario;
import com.espe.salud.domain.entities.antecedente.Hospitalizacion;
import com.espe.salud.domain.entities.catalogo.Dispensario;
import com.espe.salud.domain.entities.evolucion.Evolucion;
import com.espe.salud.domain.enums.Lateralidad;
import com.espe.salud.domain.enums.TipoPaciente;
import com.espe.salud.domain.entities.odontologia.HistoriaClinicaOdontologica;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private String numeroArchivo;

    @Column(name = "MZSTPAC_NOMBRE_COMPLETO")
    private String nombreCompleto;

    @Column(name = "MZSTPAC_ES_EMPLEADO")
    private Boolean esEmpleado;

    @Column(name = "MZSTPAC_ES_ESTUDIANTE")
    private Boolean esEstudiante;

    @Column(name = "MZSTPAC_ACEPTA_TRANSFUCION")
    private Boolean aceptaTransfucion;

    @Column(name = "MZSTPAC_LATERALIDAD")
    @Enumerated(EnumType.STRING)
    private Lateralidad lateralidad;

    @Column(name = "MZSTPAC_TIPO_PACIENTE")
    @Enumerated(EnumType.STRING)
    private TipoPaciente tipoPaciente;

    @Column(name = "MZSTPAC_VINCULADO_ESPE")
    private String vinculadoEspe;

    @Column(name = "MZSTPAC_SEGURO_SALUD")
    private String seguroSalud;

    @Column(name = "MZSTPAC_ASOCIACION_AFILIADA")
    private String asociacionAfiliada;

    @Column(name = "MZSTPAC_INSTRUCCION")
    private String instruccion;

    @Column(name = "FK_CDIS_PAC")
    private Long idDispensario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_CDIS_PAC", insertable = false, updatable = false)
    private Dispensario dispensario;

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

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Hospitalizacion> hospitalizaciones;

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

    public void setPacienteAsExterno() {
        this.tipoPaciente = TipoPaciente.EXTERNO;
        this.esEmpleado = false;
        this.esEstudiante = false;
    }

    public void setPacienteAsInterno() {
        this.tipoPaciente = TipoPaciente.INTERNO;
    }
}
